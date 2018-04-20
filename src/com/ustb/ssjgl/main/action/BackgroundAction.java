package com.ustb.ssjgl.main.action;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.ustb.ssjgl.common.action.AbstractAction;
import com.ustb.ssjgl.common.utils.CommonUtils;
import com.ustb.ssjgl.common.utils.LogUtils;
import com.ustb.ssjgl.main.bean.CombFunctionInfo;
import com.ustb.ssjgl.main.bean.InteratomicPotentials;
import com.ustb.ssjgl.main.bean.PotenFunction;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFile;
import com.ustb.ssjgl.main.service.IInteratomicPotentialsService;
import com.ustb.ssjgl.main.service.IPotentialsFunctionService;
import com.ustb.ssjgl.main.service.impl.FtpService;

/**
 * InteratomicPotentialsAction
 * @author linych
 * @version 1.0
 *
 */
@Controller
public class BackgroundAction extends AbstractAction{
    
    /**
     * logger
     */
    private final static Logger LOG = LogUtils.getLogger();

    @Autowired
    private IInteratomicPotentialsService interatomicPotentialsService;

    @Autowired
    private IPotentialsFunctionService potentialsFunctionService;
    
    @Autowired
    private FtpService ftpService;
    /**
     * 新增原子间势
     * 包括原子间势描述、标签、组合详情
     * @param request
     * @param response
     */
    @RequestMapping("/manage/addPotentials")
    @ResponseBody
    public void addPotentials(HttpServletRequest request, HttpServletResponse response) {
        String json = request.getParameter("interPotenJson");
        Map<String, Object> result = new HashMap<String, Object>();
        try{
            JSONObject interPotenJson = JSONObject.parseObject(json);
            InteratomicPotentials interPoten = new InteratomicPotentials(interPotenJson);
            interatomicPotentialsService.addInteratomicPotentials(interPoten);
            result.put("success", true);
        }catch(Exception e){
            LOG.error("无法保存原子间势，json为:{}", json, e);
            result.put("success", false);
        }
        this.writeAjaxObject(response, result);
    }

    /**
     * 新增元素组合的函数
     * @param request
     * @param response
     */
    @RequestMapping("/manage/addCombFunction")
    @ResponseBody
    public void addCombFunction(HttpServletRequest request, HttpServletResponse response) {
        String json = request.getParameter("combFunctionJson");
        Map<String, Object> result = new HashMap<String, Object>();
        try{
            JSONObject combFunJson = JSONObject.parseObject(json);
            CombFunctionInfo combFunInfo = new CombFunctionInfo(combFunJson);
            interatomicPotentialsService.addCombFunction(combFunInfo);
            result.put("success", true);
        }catch(Exception e){
            LOG.error("无法保存原子间势，json为:{}", json, e);
            result.put("success", false);
        }
        this.writeAjaxObject(response, result);
    }
    
    /**
     * 上传势文件
     * @param request
     * @param response
     */
    @RequestMapping(value="/manage/uploadPotentialsFile", method=RequestMethod.POST)
    @ResponseBody
    public void uploadPotenFile(HttpServletRequest request, HttpServletResponse response,
            @RequestParam("potentialsId") String potentialsId,
            @RequestParam("potenFile") MultipartFile multipartFile) {
        //如果文件不为空，写入上传路径
        if(!multipartFile.isEmpty()) {
            File file = null;
            String remoteFileName = potentialsId + "." + CommonUtils.getFileSuffix(multipartFile.getOriginalFilename());
            try {
                file = File.createTempFile(multipartFile.getName(), null);
                
                FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);  
                ftpService.setLocal(file);
                ftpService.setRemotePath("pub");
                ftpService.setRemote(remoteFileName);
                ftpService.upload();
                
                TPotentialsFile ptentialsFile = new TPotentialsFile();
                ptentialsFile.setcFileName(multipartFile.getOriginalFilename());
                ptentialsFile.setcElementCombId(potentialsId);
                ptentialsFile.setnSize(FileUtils.sizeOf(file));
                ptentialsFile.setcSuffix(CommonUtils.getFileSuffix(multipartFile));
                ptentialsFile.setcFtpUrlPath("pub/");
                interatomicPotentialsService.addPotentialsFile(ptentialsFile);
            } catch (Exception e) {
                LOG.error("上传文件到ftp服务器失败！", e);
                //TODO 增加向前端返回错误的处理
            }finally{
                FileUtils.deleteQuietly(file);
            }
        }
//        this.writeAjaxObject(response, result);
    }
    
    /**
     * 上传势文件
     * @param request
     * @param response
     */
    @RequestMapping(value="/manage/downloadPotentialsFile")
    @ResponseBody
    public ResponseEntity<byte[]> downloadPotenFile(HttpServletRequest request, HttpServletResponse response) {
        String potentialsId = request.getParameter("potentialsId");
        TPotentialsFile fileMeta = interatomicPotentialsService.getPotentialsFileMetaByCombId(potentialsId);
        String suffix = CommonUtils.getFileSuffix(fileMeta.getcFileName());
        File file = null;
        try {
            file = File.createTempFile("potenFile", suffix);
            ftpService.setLocal(file);
            ftpService.setRemote(fileMeta.getFtpFileName());
            ftpService.setRemotePath(fileMeta.getcFtpUrlPath());
            ftpService.download();
            response.setContentType("application/force-download");
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileMeta.getcFileName(), "UTF-8"));
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), HttpStatus.CREATED);  
        } catch (IOException e) {
            LOG.error("下载势数据文件出错！ftpPath:{},fileName:{}",fileMeta.getcFtpUrlPath() ,fileMeta.getcFileName(), e);
            throw new RuntimeException(e);
        }finally{
            FileUtils.deleteQuietly(file);
        }
    }
    
    /**
     * 删除原子间势
     * @param request
     * @param response
     */
    @RequestMapping("/manage/deletePotentials")
    @ResponseBody
    public void deletePotentials(HttpServletRequest request, HttpServletResponse response) {
        String pId = request.getParameter("potentialsId");
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            interatomicPotentialsService.deletePotentialsById(pId);
            result.put("success", true);
        } catch (Exception e) {
            LOG.error("删除原子间势出错！", e);
            result.put("success", false);
        }
        this.writeAjaxObject(response, result);
    }
    
    /**
     * 删除上传的势数据文件
     * @param request
     * @param response
     */
    @RequestMapping("/manage/deletePotenFile")
    @ResponseBody
    public void deletePotenFile(HttpServletRequest request, HttpServletResponse response) {
        String pId = request.getParameter("potentialsId");
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            interatomicPotentialsService.deletePotenFileByPotenId(pId);
            result.put("success", true);
        } catch (Exception e) {
            LOG.error("删除势数据文件出错！", e);
            result.put("success", false);
        }
        this.writeAjaxObject(response, result);
    }
    
    /**
     * 删除元素组合的函数
     * @param request
     * @param response
     */
    @RequestMapping("/manage/deleteCombFunction")
    @ResponseBody
    public void deleteCombFunction(HttpServletRequest request, HttpServletResponse response) {
        String pId = request.getParameter("potentialsId");
        String functionId = request.getParameter("functionId");
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            interatomicPotentialsService.deleteCombFunction(pId, functionId);
            result.put("success", true);
        } catch (Exception e) {
            LOG.error("删除组合的势函数出错！", e);
            result.put("success", false);
        }
        this.writeAjaxObject(response, result);
    }
    /**
     * 新增势函数
     * @param request
     * @param response
     */
    @RequestMapping("/manage/addFunction")
    @ResponseBody
    public void addPotentialsFunction(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            String json = request.getParameter("potenFunctionJson");
            JSONObject potenFunctionJson = JSONObject.parseObject(json);
            PotenFunction function = new PotenFunction(potenFunctionJson);
            potentialsFunctionService.addFunction(function);
            result.put("success", true);
        } catch (Exception e) {
            LOG.error("新增势函数出错！", e);
            result.put("success", false);
        }
        this.writeAjaxObject(response, result);
    }

    /**
     * 删除势函数
     * @param request
     * @param response
     */
    @RequestMapping("/manage/deleteFunction")
    @ResponseBody
    public void deletePotentialsFunction(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            String functionId = request.getParameter("functionId");
            potentialsFunctionService.deleteFunctionById(functionId);
            result.put("success", true);
        } catch (Exception e) {
            LOG.error("新增势函数出错！", e);
            result.put("success", false);
        }
        this.writeAjaxObject(response, result);
    }
}
