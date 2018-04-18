package com.ustb.ssjgl.main.action;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.ustb.ssjgl.common.action.AbstractAction;
import com.ustb.ssjgl.common.utils.FtpUtils;
import com.ustb.ssjgl.common.utils.LogUtils;
import com.ustb.ssjgl.main.bean.InteratomicPotentials;
import com.ustb.ssjgl.main.bean.PotenFunction;
import com.ustb.ssjgl.main.service.IInteratomicPotentialsService;
import com.ustb.ssjgl.main.service.IPotentialsFunctionService;

/**
 * InteratomicPotentialsAction
 * @author linych
 * @version 1.0
 *
 */
@Controller
public class InteratomicPotentialsAction extends AbstractAction{
    
    /**
     * logger
     */
    private final static Logger LOG = LogUtils.getLogger();

    private IInteratomicPotentialsService interatomicPotentialsService;

    private IPotentialsFunctionService potentialsFunctionService;
    
    /**
     * 新增原子间势
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
            LOG.error("删除原子间势出错！", e);
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
            @RequestParam("potentialsId") String description,
            @RequestParam("potenFile") MultipartFile multipartFile) {
        
        //如果文件不为空，写入上传路径
        if(!multipartFile.isEmpty()) {
            try {
                File file = File.createTempFile(multipartFile.getName(), null);
                FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);  
                FtpUtils ftpUtils = new FtpUtils();
                ftpUtils.setLocal(file);
                ftpUtils.setRemotePath("pub");
                ftpUtils.setRemote(multipartFile.getOriginalFilename());
                ftpUtils.upload();
            } catch (Exception e) {
                LOG.error("上传文件到ftp服务器失败！", e);
            }
        }
        
//        this.writeAjaxObject(response, result);
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
