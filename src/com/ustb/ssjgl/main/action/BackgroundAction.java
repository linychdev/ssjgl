package com.ustb.ssjgl.main.action;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
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
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.ustb.ssjgl.common.action.AbstractAction;
import com.ustb.ssjgl.common.paging.Page;
import com.ustb.ssjgl.common.utils.CommonUtils;
import com.ustb.ssjgl.common.utils.DateUtils;
import com.ustb.ssjgl.common.utils.JsonUtils;
import com.ustb.ssjgl.common.utils.LogUtils;
import com.ustb.ssjgl.common.utils.UuidUtils;
import com.ustb.ssjgl.login.dao.bean.TUser;
import com.ustb.ssjgl.login.service.ISessionService;
import com.ustb.ssjgl.login.service.IUserService;
import com.ustb.ssjgl.main.bean.CombFunctionInfo;
import com.ustb.ssjgl.main.bean.InteratomicPotentials;
import com.ustb.ssjgl.main.bean.PotenFunction;
import com.ustb.ssjgl.main.bean.TReferenceInfo;
import com.ustb.ssjgl.main.dao.bean.TElement;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFile;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFunction;
import com.ustb.ssjgl.main.dao.bean.TReference;
import com.ustb.ssjgl.main.service.IInterPotenService;
import com.ustb.ssjgl.main.service.IPotenFunctionService;
import com.ustb.ssjgl.main.service.impl.FtpService;
import com.ustb.ssjgl.visitlog.service.IVisitLogService;

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
    private static final Logger LOG = LogUtils.getLogger();

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
    
    @Autowired
    private IVisitLogService visitLogService;
    
    /**
     * 新增原子间势
     * 包括原子间势描述、标签、组合详情
     * @param request
     * @param response
     */
    @RequestMapping("/manage/addPotentials")
    @ResponseBody
    public void addPotentials(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> result = Maps.newHashMap();
        try{
            String combId = request.getParameter("combId");
            String potenGroup = request.getParameter("potenGroup");
            String potenName = request.getParameter("potenName");
            String potenDesc = request.getParameter("potenDesc");
            String potenNote = request.getParameter("potenNote");
            String elements = request.getParameter("elements");
            String functions = request.getParameter("functions");
            JSONObject interPotenJson = new JSONObject();
            
            interPotenJson.put("combId", combId);
            interPotenJson.put("scopeId", potenGroup);
            interPotenJson.put("combName", potenName);
            interPotenJson.put("combDescription", potenDesc);
            interPotenJson.put("combNote", potenNote);
            
            String[] functionArray = functions.split(",");
            JSONArray funIdJsonArray = new JSONArray();
            for (String funName : functionArray) {
                TPotentialsFunction function = potenFunctionService.selectByName(StringUtils.trim(funName));
                JSONObject funJson = new JSONObject();
                funJson.put("functionId", function.getcId());
                funIdJsonArray.add(funJson);
            }
            interPotenJson.put("functions", funIdJsonArray);
            
            String[] eles = elements.split(",");
            JSONArray elementJsonArray = new JSONArray();
            for (String eName : eles) {
                TElement element = interPotenService.getElementBySymbol(StringUtils.trim(eName));
                String eId = element.getcId();
                JSONObject e = new JSONObject();
                e.put("elementId", eId);
                elementJsonArray.add(e);
            }
            interPotenJson.put("combDetails", elementJsonArray);
            
            if(StringUtils.isNotBlank(combId)){
                interPotenService.deleteCombById(combId);
                interPotenService.deleteCombDetailByCombId(combId);
                interPotenService.deleteCombTagByCombId(combId);
                interPotenService.deleteCombFunctionBycombId(combId);
            }
            InteratomicPotentials interPoten = new InteratomicPotentials(interPotenJson);
            interPotenService.addInteratomicPotentials(interPoten);
            result.put("success", true);
            result.put("combId", interPoten.getElementComb().getcId());
        }catch(Exception e){
            LOG.error("无法保存原子间势", e);
            result.put("success", false);
            result.put("msg", "无法保存原子间势!");
        }
        this.writeAjaxObject(response, result);
    }
    
    @RequestMapping("/manage/addPotenReference")
    @ResponseBody
    public void addPotenReference(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> result =  Maps.newHashMap();
        String json = request.getParameter("potenRefJson");
        try{
            JSONObject reference = JSONObject.parseObject(json);
            String combId = JsonUtils.getStrFromJson(reference, "combId");
            JSONArray references = JsonUtils.getJSONArrayFromJson(reference, "references");

            List<TReference> refList = Lists.newArrayList();
            for (Object refObj : references) {
                JSONObject refJson = (JSONObject) refObj;
                int refSource = JsonUtils.getIntegerFromJson(refJson, "refSource");
                String refId = JsonUtils.getStrFromJson(refJson, "refId");
                String content = JsonUtils.getStrFromJson(refJson, "content");
                String doi = JsonUtils.getStrFromJson(refJson, "doi");
                String note = JsonUtils.getStrFromJson(refJson, "note");
                TReference ref = new TReference();
                if(StringUtils.isNotBlank(refId)){
                    ref.setcId(refId);
                }
                ref.setcElementCombId(combId);
                ref.setcContent(content);
                ref.setcDoi(doi);
                ref.setcNote(note);
                ref.setnSource(refSource);
                refList.add(ref);
                interPotenService.saveOrUpdateReference(ref);
            }
            result.put("success", true);
            result.put("refList", refList);
        }catch(Exception e){
            LOG.error("无法保存参考文献，json为:{}", json, e);
            result.put("success", false);
            result.put("msg", "无法保存参考文献"+e.getMessage());
        }
        this.writeAjaxObject(response, result);
    }
    
    @RequestMapping("/manage/deletePotenReference")
    @ResponseBody
    public void deletePotenReference(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> result =  Maps.newHashMap();
        String refId = request.getParameter("refId");
        try{
            List<TPotentialsFile> fileMetaList = interPotenService.getPotentialsFileMetaByRefId(refId);
            for (TPotentialsFile potenFile : fileMetaList) {
                ftpService.setRemote(potenFile.getRemote());
                ftpService.delete();
            }
            interPotenService.deleteReferenceById(refId);
            result.put("success", true);
        }catch(Exception e){
            LOG.error("删除参考文献失败！", e);
            result.put("success", false);
            result.put("msg", "删除参考文献失败！"+e.getMessage());
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
        Map<String, Object> result = Maps.newHashMap();
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
            @RequestParam("refId") String refId,
            @RequestParam("potentialsType") Integer potentialsType,
            @RequestParam("potenFile") MultipartFile potenFile) {
        
        Map<String, Object> result = Maps.newHashMap();
        //如果文件不为空，写入上传路径
        if(!potenFile.isEmpty()) {
            File file = null;
            String remoteFileName = UuidUtils.getUuid() + "." + CommonUtils.getFileSuffix(potenFile.getOriginalFilename());
            try {
                file = File.createTempFile(potenFile.getName(), null);
                
                FileUtils.copyInputStreamToFile(potenFile.getInputStream(), file);  
                ftpService.setLocal(file);
                ftpService.setRemote(remoteFileName);
                ftpService.upload();
                
                TPotentialsFile potentialsFile = new TPotentialsFile();
                potentialsFile.setcFileName(potenFile.getOriginalFilename());
                potentialsFile.setcReferenceId(refId);
                potentialsFile.setnFileType(potentialsType);
                potentialsFile.setnSize(FileUtils.sizeOf(file));
                potentialsFile.setcSuffix(CommonUtils.getFileSuffix(potenFile));
                potentialsFile.setcFtpUrlPath(ftpService.getRemotePath()+"/"+remoteFileName);
                interPotenService.addPotentialsFile(potentialsFile);
                result.put("success", true);
                result.put("potentialsFile", potentialsFile);
            } catch (Exception e) {
                LOG.error("上传文件到ftp服务器失败！", e);
                result.put("success", false);
                result.put("msg", "上传文件到ftp服务器失败!" + e.getMessage());
            }finally{
                FileUtils.deleteQuietly(file);
            }
        }else{
            result.put("success", false);
            result.put("msg", "不能上传空文件！");
        }
        this.writeAjaxObject(response, result);
    }

    

    /**
     * 编辑原子间势时，先查询详情
     * @param combId
     * @return
     */
    @RequestMapping("/manage/selectComb")
    @ResponseBody
    public void editorElementComb(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> result = Maps.newHashMap();
        String combId = request.getParameter("combId");
        InteratomicPotentials interPoten = interPotenService.getInterPotenByCombId(combId);
        result.put("combDetail", interPoten);
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
        Map<String, Object> result = Maps.newHashMap();
        String pId = request.getParameter("potentialsId");
        try {
            //删除ftp文件
            InteratomicPotentials interPoten = interPotenService.getInterPotenByCombId(pId);
            List<TReferenceInfo> refInfos = interPoten.getReferenceInfos();
            for (TReferenceInfo refInfo : refInfos) {
                List<TPotentialsFile> fileMates = refInfo.getPotentialsFiles();
                for (TPotentialsFile potenFile : fileMates) {
                    ftpService.setRemote(potenFile.getRemote());
                    ftpService.delete();
                    
                }
            }
            //刪除元数据
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
        String fileId = request.getParameter("fileId");
        Map<String, Object> result = Maps.newHashMap();
        try {
            TPotentialsFile potenFile = interPotenService.getPotentialsFileMetaById(fileId);
            ftpService.setRemote(potenFile.getRemote());
            ftpService.delete();
            interPotenService.deletePotenFileById(fileId);
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
        Map<String, Object> result = Maps.newHashMap();
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
        Map<String, Object> result = Maps.newHashMap();
        try {
            String json = request.getParameter("potenFunctionJson");
            String operationType = request.getParameter("operationType");
            String functionId = request.getParameter("functionId");
            JSONObject potenFunctionJson = JSONObject.parseObject(string2Json(json));
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
        String functionDesc = JsonUtils.getStrFromJson(potenFunctionJson, "functionDesc");
        function.setcName(functionName);
        function.setcFormula(functionFormula);
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
        Map<String, Object> result = Maps.newHashMap();
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
        Map<String, Object> result = Maps.newHashMap();
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
        String scopeId = request.getParameter("scopeId");
        String combName = request.getParameter("combName");
        if(StringUtils.isNotBlank(scopeId)){
            filter.put("scopeId", scopeId);
        }
        if(StringUtils.isNotBlank(combName)){
            filter.put("combName", combName);
        }
        int pageIndex = NumberUtils.toInt(request.getParameter("pageIndex"), 1);
        //默认每页显示15行
        int pageSize = NumberUtils.toInt(request.getParameter("pageSize"), 15);
        
        Page<?> pageData = interPotenService.getShowInfoListByPaging(filter, pageSize, pageIndex);
        List<TElement> elementList = interPotenService.getAllElements();
        ModelAndView mode = new ModelAndView();
        
        mode.addObject("scopeId", scopeId != null ? scopeId : "");
        mode.addObject("combName", combName != null ? combName : "");
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
        Map<String, Object> result = Maps.newHashMap();
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

    /**
     * 获取活跃度页面
     * @param request
     * @param response
     */
    @RequestMapping("/background/visiterPage")
    @ResponseBody
    public ModelAndView getVisiterPage(HttpServletRequest request, HttpServletResponse response) {
        
        String beginDate = request.getParameter("beginDate");
        String endDate = request.getParameter("endDate");
        if(beginDate == null){
            beginDate = DateUtils.formatDate(DateUtils.addDays(new Date(), -30),"yyyy-MM-dd");
        }
        if(endDate == null){
            endDate = DateUtils.formatDate(new Date(),"yyyy-MM-dd");
        }
        //页面浏览量
        int ymlll = visitLogService.getTotalVisitTimes(beginDate, endDate);
        int syfwl = visitLogService.getIndexPageVisitTimes(beginDate, endDate);
        int dlipfwl = visitLogService.getDisIpVisitTimes(beginDate, endDate);
        
        JSONArray ymlllJsonArray = new JSONArray();
        List<Map<String,Integer>> ymlllList = visitLogService.getDaylyVisitTimes(beginDate, endDate);
        for (Map<String, Integer> map : ymlllList) {
            JSONObject json = new JSONObject();
            json.put("dateStr", map.get("dateStr"));
            json.put("total", map.get("total"));
            ymlllJsonArray.add(json);
        }
        
        
        ModelAndView mode = new ModelAndView();
        mode.addObject("ymlll", ymlll);
        mode.addObject("syfwl", syfwl);
        mode.addObject("dlipfwl", dlipfwl);
        mode.addObject("ymlllListJson", ymlllJsonArray);
        mode.addObject("beginDate", "'"+beginDate+"'");
        mode.addObject("endDate", "'"+endDate+"'");
        mode.setViewName("background/visitLog");
        return mode;
    }

    /**
     * 获取搜索统计页面
     * @param request
     * @param response
     */
    @RequestMapping("/background/searchPage")
    @ResponseBody
    public ModelAndView getSearchPage(HttpServletRequest request, HttpServletResponse response) {
        
        String beginDate = request.getParameter("beginDate");
        String endDate = request.getParameter("endDate");
        String validSearch = request.getParameter("validSearch");
        if(beginDate == null){
            beginDate = DateUtils.formatDate(new Date(0),"yyyy-MM-dd");
        }
        if(endDate == null){
            endDate = DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss");
        }
        
        JSONArray hotSearchJsonArray = new JSONArray();
        List<Map<String,Integer>> hotSearchList = visitLogService.getHotSearchList(beginDate, endDate);
        for (Map<String, Integer> map : hotSearchList) {
            JSONObject json = new JSONObject();
            json.put("searchText", map.get("searchText"));
            json.put("total", map.get("total"));
            hotSearchJsonArray.add(json);
        }
        JSONArray invalidSearchJsonArray = new JSONArray();
        List<Map<String,Integer>> invalidSearchList = visitLogService.getInvalidSearchList(beginDate, endDate);
        for (Map<String, Integer> map : invalidSearchList) {
            JSONObject json = new JSONObject();
            json.put("searchText", map.get("searchText"));
            json.put("total", map.get("total"));
            invalidSearchJsonArray.add(json);
        }
        JSONArray hotPotenJsonArray = new JSONArray();
        List<Map<String,Integer>> hotPotenList = visitLogService.getHotPotenList(beginDate, endDate);
        for (Map<String, Integer> map : hotPotenList) {
            JSONObject json = new JSONObject();
            json.put("searchText", map.get("searchText"));
            json.put("total", map.get("total"));
            hotPotenJsonArray.add(json);
        }
        
        
        Map<String, Object> filter = Maps.newHashMap();
        int pageIndex = NumberUtils.toInt(request.getParameter("pageIndex"), 1);
        //默认每页显示15行
        int pageSize = NumberUtils.toInt(request.getParameter("pageSize"), 15);
        filter.put("endDate", endDate);
        filter.put("beginDate", beginDate);
        filter.put("validSearch", validSearch);
        
        Page<?> pageData = visitLogService.getSearchListByPaging(filter, pageSize, pageIndex);
        
        
        ModelAndView mode = new ModelAndView();
        mode.addObject("hotSearchListJson", hotSearchJsonArray);
        mode.addObject("invalidSearchListJson", invalidSearchJsonArray);
        mode.addObject("hotPotenListJson", hotPotenJsonArray);
        mode.addObject("pageData", pageData);
        mode.setViewName("background/searchLog");
        return mode;
    }

    /**
     * 获取下载统计页面
     * @param request
     * @param response
     */
    @RequestMapping("/background/downloadPage")
    @ResponseBody
    public ModelAndView getDownLoadPage(HttpServletRequest request, HttpServletResponse response) {
        String beginDate = request.getParameter("beginDate");
        String endDate = request.getParameter("endDate");
        if(beginDate == null){
            beginDate = DateUtils.formatDate(DateUtils.addDays(new Date(), -30),"yyyy-MM-dd");
        }
        if(endDate == null){
            endDate = DateUtils.formatDate(new Date(),"yyyy-MM-dd");
        }
        
        int totalDownLoadNum = visitLogService.getTotalDownloadTimes();
        int tjqDownLoadNum = visitLogService.getTjqDownloadVisitTimes(beginDate, endDate);
        
        JSONArray tjqDownLoadListJsonArray = new JSONArray();
        List<Map<String,Integer>> downLoadList = visitLogService.getDownloadList(beginDate, endDate);
        for (Map<String, Integer> map : downLoadList) {
            JSONObject json = new JSONObject();
            json.put("dateStr", map.get("dateStr"));
            json.put("total", map.get("total"));
            tjqDownLoadListJsonArray.add(json);
        }
        
        Map<String, Object> filter = Maps.newHashMap();
        int pageIndex = NumberUtils.toInt(request.getParameter("pageIndex"), 1);
        //默认每页显示15行
        int pageSize = NumberUtils.toInt(request.getParameter("pageSize"), 15);
        filter.put("endDate", endDate);
        filter.put("beginDate", beginDate);
        
        Page<?> pageData = visitLogService.getDownloadListByPaging(filter, pageSize, pageIndex);
        
        ModelAndView mode = new ModelAndView();
        mode.addObject("totalDownLoadNum", totalDownLoadNum);
        mode.addObject("tjqDownLoadNum", tjqDownLoadNum);
        mode.addObject("tjqDownLoadListJson", tjqDownLoadListJsonArray);
        mode.addObject("beginDate", "'"+beginDate+"'");
        mode.addObject("endDate", "'"+endDate+"'");
        mode.addObject("pageData", pageData);
        mode.setViewName("background/downLoadLog");
        return mode;
    }
    
    /**
     * 获取资源统计页面
     * @param request
     * @param response
     */
    @RequestMapping("/background/resourcePage")
    @ResponseBody
    public ModelAndView getResourcePagePage(HttpServletRequest request, HttpServletResponse response) {
        int totalFunctioNum = potenFunctionService.getCountFunctionNum();
        int totalPotenNum = interPotenService.getCountPotenNum();
        int totalFileNum = interPotenService.getCountFileNum();
        
        JSONArray potenGroupListJsonArray = new JSONArray();
        List<Map<String,Integer>> potenGroupList = interPotenService.getPotenGroup();
        for (Map<String, Integer> map : potenGroupList) {
            JSONObject json = new JSONObject();
            json.put("groupName", map.get("groupName"));
            json.put("total", map.get("total"));
            potenGroupListJsonArray.add(json);
        }
        
        ModelAndView mode = new ModelAndView();
        mode.addObject("totalFunctioNum", totalFunctioNum);
        mode.addObject("totalPotenNum", totalPotenNum);
        mode.addObject("totalFileNum", totalFileNum);
        mode.addObject("potenGroupListJson", potenGroupListJsonArray);
        mode.setViewName("background/resource");
        return mode;
    }
    

    @RequestMapping("/background/deleteUser")
    @ResponseBody
    public void deleteUser(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
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
    
    private String string2Json(String s) {     
        StringBuffer sb = new StringBuffer();     
        for (int i=0; i<s.length(); i++) {     
            char c = s.charAt(i);     
            switch (c) {     
            case '\\':     
                sb.append("\\\\");     
                break;     
            case '/':     
                sb.append("\\/");     
                break;     
            case '\b':     
                sb.append("\\b");     
                break;     
            case '\f':     
                sb.append("\\f");     
                break;     
            case '\n':     
                sb.append("\\n");     
                break;     
            case '\r':     
                sb.append("\\r");     
                break;     
            case '\t':     
                sb.append("\\t");     
                break;     
            default:     
                sb.append(c);     
            }
       }
        return sb.toString();     
     }
}
