package com.ustb.ssjgl.main.action;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.ustb.ssjgl.common.SsjglContants;
import com.ustb.ssjgl.common.action.AbstractAction;
import com.ustb.ssjgl.common.paging.Page;
import com.ustb.ssjgl.common.utils.CommonUtils;
import com.ustb.ssjgl.common.utils.JsonUtils;
import com.ustb.ssjgl.common.utils.LogUtils;
import com.ustb.ssjgl.common.utils.UuidUtils;
import com.ustb.ssjgl.login.dao.bean.TUser;
import com.ustb.ssjgl.login.service.ISessionService;
import com.ustb.ssjgl.login.service.IUserService;
import com.ustb.ssjgl.main.bean.CombFunctionInfo;
import com.ustb.ssjgl.main.bean.InteratomicPotentials;
import com.ustb.ssjgl.main.bean.PotenFunction;
import com.ustb.ssjgl.main.dao.bean.TElement;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFile;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFunction;
import com.ustb.ssjgl.main.dao.bean.TReference;
import com.ustb.ssjgl.main.service.IInterPotenService;
import com.ustb.ssjgl.main.service.IPotenFunctionService;
import com.ustb.ssjgl.main.service.impl.FtpService;

/**
 * BackgroundAction
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
    private IInterPotenService interPotenService;

    @Autowired
    private IPotenFunctionService potenFunctionService;
    
    @Autowired
    private FtpService ftpService;
    
    @Autowired
    private IUserService userService;

    @Autowired
    private ISessionService sessionService;
    
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
            interPotenService.addInteratomicPotentials(interPoten);
            result.put("success", true);
        }catch(Exception e){
            LOG.error("无法保存原子间势，json为:{}", json, e);
            result.put("success", false);
        }
        this.writeAjaxObject(response, result);
    }

    @RequestMapping("/manage/addPotenReference")
    @ResponseBody
    public void addPotenReference(HttpServletRequest request, HttpServletResponse response) {
        String json = request.getParameter("potenRefJson");
        Map<String, Object> result = new HashMap<String, Object>();
        try{
            JSONObject reference = JSONObject.parseObject(json);
            String combId = JsonUtils.getStrFromJson(reference, "combId");
            String content = JsonUtils.getStrFromJson(reference, "content");
            String doi = JsonUtils.getStrFromJson(reference, "doi");
            String note = JsonUtils.getStrFromJson(reference, "note");
            TReference ref = new TReference();
            ref.setcElementCombId(combId);
            ref.setcContent(content);
            ref.setcDoi(doi);
            ref.setcNote(note);
            ref.setnSource(SsjglContants.REFERENCE_SOURCE_SSJGL);
            interPotenService.addReference(ref);
            result.put("success", true);
        }catch(Exception e){
            LOG.error("无法保存参考文献，json为:{}", json, e);
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
            interPotenService.addCombFunction(combFunInfo);
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
            @RequestParam("relatedId") String relatedId,
            @RequestParam("potentialsType") Integer potentialsType,
            @RequestParam("potenFile") MultipartFile multipartFile) {
        
        Map<String, Object> result = new HashMap<String, Object>();
        //如果文件不为空，写入上传路径
        if(!multipartFile.isEmpty()) {
            File file = null;
            String remoteFileName = UuidUtils.getUuid() + "." + CommonUtils.getFileSuffix(multipartFile.getOriginalFilename());
            try {
                file = File.createTempFile(multipartFile.getName(), null);
                
                FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);  
                ftpService.setLocal(file);
                ftpService.setRemote(remoteFileName);
                ftpService.upload();
                
                TPotentialsFile potentialsFile = new TPotentialsFile();
                potentialsFile.setcFileName(multipartFile.getOriginalFilename());
                potentialsFile.setcReferenceId(relatedId);
                potentialsFile.setnSize(FileUtils.sizeOf(file));
                potentialsFile.setcSuffix(CommonUtils.getFileSuffix(multipartFile));
                potentialsFile.setcFtpUrlPath(ftpService.getRemotePath()+File.separator+remoteFileName);
                interPotenService.addPotentialsFile(potentialsFile);
                result.put("success", true);
            } catch (Exception e) {
                LOG.error("上传文件到ftp服务器失败！", e);
                result.put("success", false);
            }finally{
                FileUtils.deleteQuietly(file);
            }
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
            interPotenService.deletePotentialsById(pId);
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
            interPotenService.deletePotenFileByPotenId(pId);
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
            interPotenService.deleteCombFunction(pId, functionId);
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
            String operationType = request.getParameter("operationType");
            String functionId = request.getParameter("functionId");
            JSONObject potenFunctionJson = JSONObject.parseObject(json);
            if(operationType.equals("update")){
                updateFunction(functionId, potenFunctionJson);
            }else{
                saveFunction(potenFunctionJson);
            }
            result.put("success", true);
        } catch (Exception e) {
            LOG.error("新增势函数出错！", e);
            result.put("success", false);
        }
        this.writeAjaxObject(response, result);
    }

    private void updateFunction(String functionId, JSONObject potenFunctionJson) {
        TPotentialsFunction function = potenFunctionService.selectById(functionId);
        String functionName = JsonUtils.getStrFromJson(potenFunctionJson, "functionName");
        String functionFormula = JsonUtils.getStrFromJson(potenFunctionJson, "functionFormula");
        String functionFormulaHtml = JsonUtils.getStrFromJson(potenFunctionJson, "functionFormulaHtml");
        String functionDesc = JsonUtils.getStrFromJson(potenFunctionJson, "functionDesc");
        function.setcName(functionName);
        function.setcFormula(functionFormula);
        function.setcFormulaHtml(functionFormulaHtml);
        function.setcDescription(functionDesc);
        potenFunctionService.updateFunction(function);
    }

    private void saveFunction(JSONObject potenFunctionJson) {
        PotenFunction function = new PotenFunction(potenFunctionJson);
        potenFunctionService.addFunction(function);
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
            boolean deleteSuccess = potenFunctionService.deleteFunctionById(functionId);
            if(deleteSuccess){
                result.put("success", true);
            }else{
                result.put("success", false);
                result.put("msg", "有原子间势依赖此函数，无法删除！");
            }
        } catch (Exception e) {
            LOG.error("删除势函数出错！", e);
            result.put("success", false);
            result.put("msg", e.getMessage());
        }
        this.writeAjaxObject(response, result);
    }

    /**
     * 根据id查询势函数
     * @param request
     * @param response
     */
    @RequestMapping("/manage/selectFunction")
    @ResponseBody
    public void selectPotentialsFunction(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> result = new HashMap<String, Object>();
        String functionId = request.getParameter("functionId");
        TPotentialsFunction function = potenFunctionService.selectById(functionId);
        result.put("fun", function);
        this.writeAjaxObject(response, result);
    }

    /**
     * 跳转到后台管理页面
     * @param request
     * @param response
     */
    @RequestMapping("/background/admin")
    @ResponseBody
    public ModelAndView backgroundIndex(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mode = new ModelAndView();
        TUser user = sessionService.getCurrentUser();
        mode.addObject("user", user);
        mode.setViewName("background/admin");
        return mode;
    }

    /**
     * 跳转到登录页面
     * @param request
     * @param response
     */
    @RequestMapping("/background/login")
    @ResponseBody
    public ModelAndView loginIndex(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mode = new ModelAndView();
        mode.setViewName("login/login");
        return mode;
    }

    /**
     * 势函数列表
     * @param request
     * @param response
     */
    @RequestMapping("/background/functionList")
    @ResponseBody
    public ModelAndView getFunctionList(HttpServletRequest request, HttpServletResponse response) {
        List<TPotentialsFunction> functionList = potenFunctionService.getAllFunction();
        ModelAndView mode = new ModelAndView();
        mode.addObject("functionList", functionList);
        mode.setViewName("background/function");
        return mode;
    }

    /**
     * 势数据列表
     * @param request
     * @param response
     */
    @RequestMapping("/background/dataList")
    @ResponseBody
    public ModelAndView getPotenDataList(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> filter = Maps.newHashMap();
        int pageIndex = NumberUtils.toInt(request.getParameter("pageIndex"), 1);
        //默认每页显示15行
        int pageSize = NumberUtils.toInt(request.getParameter("pageSize"), 15);
        
        Page<?> pageData = interPotenService.getShowInfoListByPaging(filter, pageSize, pageIndex);
        List<TElement> elementList = interPotenService.getAllElements();
        ModelAndView mode = new ModelAndView();
        mode.addObject("pageData", pageData);
        mode.addObject("elementList", elementList);
        mode.setViewName("background/dataList");
        return mode;
    }

    /**
     * 元素列表
     * @param request
     * @param response
     */
    @RequestMapping("/background/elementList")
    @ResponseBody
    public void getElementList(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> result = new HashMap<String, Object>();
        List<TElement> elementList = interPotenService.getAllElements();
        List<TPotentialsFunction> functionList = interPotenService.getAllFunction();
        
        JSONArray elementJson = new JSONArray();
        for (TElement element : elementList) {
            JSONObject jo = new JSONObject();
            jo.put("id", element.getcId());
            jo.put("name", element.getcSymbol());
            elementJson.add(jo);
        }

        JSONArray funJson = new JSONArray();
        for (TPotentialsFunction fun : functionList) {
            JSONObject jo = new JSONObject();
            jo.put("id", fun.getcId());
            jo.put("name", fun.getcName());
            funJson.add(jo);
        }
        result.put("elementList", elementJson);
        result.put("functionList", funJson);
        this.writeAjaxObject(response, result);
    }

    /**
     * 用户列表(普通管理员)
     * @param request
     * @param response
     */
    @RequestMapping("/background/userList")
    @ResponseBody
    public ModelAndView getUserList(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> filter = Maps.newHashMap();
        int pageIndex = NumberUtils.toInt(request.getParameter("pageIndex"), 1);
        //默认每页显示15行
        int pageSize = NumberUtils.toInt(request.getParameter("pageSize"), 15);
        
        Page<?> pageData = userService.getUserListByPaging(filter, pageSize, pageIndex);
        boolean isAdmin = sessionService.isCurrentAdmin();
        ModelAndView mode = new ModelAndView();
        mode.addObject("pageData", pageData);
        mode.addObject("isAdmin", isAdmin);
        mode.setViewName("background/userList");
        return mode;
    }
    

    @RequestMapping("/background/deleteUser")
    @ResponseBody
    public void deleteUser(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            String userId = request.getParameter("userId");
            userService.deleteUser(userId);
            result.put("success", true);
        } catch (Exception e) {
            LOG.error("删除用户出错！", e);
            result.put("success", false);
            result.put("msg", e.getMessage());
        }
        this.writeAjaxObject(response, result);
    }
}
