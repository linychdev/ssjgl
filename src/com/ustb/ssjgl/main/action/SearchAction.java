package com.ustb.ssjgl.main.action;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.ustb.ssjgl.common.action.AbstractAction;
import com.ustb.ssjgl.common.utils.CommonUtils;
import com.ustb.ssjgl.common.utils.LogUtils;
import com.ustb.ssjgl.login.service.ISessionService;
import com.ustb.ssjgl.main.bean.InteratomicPotentials;
import com.ustb.ssjgl.main.dao.bean.ElementCombShowInfo;
import com.ustb.ssjgl.main.dao.bean.TElementCombination;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFile;
import com.ustb.ssjgl.main.service.IInterPotenService;
import com.ustb.ssjgl.main.service.impl.FtpService;
import com.ustb.ssjgl.visitlog.annotation.VisitLog;
import com.ustb.ssjgl.visitlog.annotation.VisitLogType;

/**
 * SearchAction
 * @author linych
 * @version 1.0
 *
 */
@Controller
public class SearchAction extends AbstractAction{
    
    /**
     * logger
     */
    private final static Logger LOG = LogUtils.getLogger();

    @Autowired
    private IInterPotenService interPotenService;

    @Autowired
    private FtpService ftpService;
    
    @Autowired
    private ISessionService sessionService;
    
    @VisitLog(VisitLogType.SEARCH)
    @RequestMapping(value = "/search/list/{tag}", method=RequestMethod.GET)
    public ModelAndView getElementCombList(@PathVariable(value = "tag") String tag) {
        List<ElementCombShowInfo> combList = interPotenService.getElementCombShowInfoListByTag(tag);
        if(combList.size() == 1){
            String combId = combList.get(0).getElementComb().getcId();
            return getElementCombDetail(combId);
        }
        
        /**
         * 设置用于词云的字体大小和内容
         */
        JSONArray jsonArray = new JSONArray();
        for (ElementCombShowInfo showInfo : combList) {
            JSONObject json = new JSONObject();
            json.put("value", (showInfo.getSearchTimes().intValue()+100*Math.random()));
            json.put("name", showInfo.getElementComb().getcCombName());
            json.put("combId", showInfo.getElementComb().getcId());
            jsonArray.add(json);
        }
        
        /**
         * 设置分组信息
         */
        Map<String, List<TElementCombination>> groupMap = Maps.newLinkedHashMap();
        for (ElementCombShowInfo showInfo : combList) {
            TElementCombination comb = showInfo.getElementComb();
            if(groupMap.containsKey(showInfo.getScope().getcName())){
                groupMap.get(showInfo.getScope().getcName()).add(comb);
            }else{
                groupMap.put(showInfo.getScope().getcName(), Lists.newArrayList(comb));
            }
        }
        
        ModelAndView mode = new ModelAndView();
        mode.setViewName("main/combList");
        mode.addObject("validSearch", 1);
        mode.addObject("combList", combList);
        mode.addObject("combListJson", jsonArray.toString());
        mode.addObject("searchText", tag);
        mode.addObject("groupMap", groupMap);
        return mode;
    }

    @RequestMapping(value = "/search/detail/{combId}", method=RequestMethod.GET)
    public ModelAndView getElementCombDetail(@PathVariable(value = "combId") String combId) {
        InteratomicPotentials interPoten = interPotenService.getInterPotenByCombId(combId);
        ModelAndView mode = new ModelAndView();
        mode.setViewName("main/combDetail");
        mode.addObject("validSearch", 1);
        mode.addObject("combDetail", interPoten);
        return mode;
    }
    /**
     * 下载势文件
     * @param request
     * @param response
     */
    @RequestMapping(value="/search/downloadPotentialsFile")
    @ResponseBody
    public ResponseEntity<byte[]> downloadPotenFile(HttpServletRequest request, HttpServletResponse response) {
        String potentialsFileId = request.getParameter("potentialsFileId");
        TPotentialsFile fileMeta = interPotenService.getPotentialsFileMetaById(potentialsFileId);
        String suffix = CommonUtils.getFileSuffix(fileMeta.getcFileName());
        File file = null;
        try {
            file = File.createTempFile("potenFile", suffix);
            String remote = fileMeta.getRemote();
            ftpService.setLocal(file);
            ftpService.setRemote(remote);
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
    
    @VisitLog(VisitLogType.BROWSE)
    @RequestMapping(value = "/index", method=RequestMethod.GET)
    public ModelAndView showSearchIndex(HttpServletRequest request) {
        ModelAndView mode = new ModelAndView();
        //判断是否第一次打开页面
        if(null == request.getHeader("Cookie")){
            mode.addObject("firstAccess", true);
        }else{
            mode.addObject("firstAccess", false);
        }
        List<String> elementNames = interPotenService.getElementNamesHasPoten();
        JSONArray jsonArray = new JSONArray();
        for (String name : elementNames) {
            JSONObject json = new JSONObject();
            json.put("name", name);
            jsonArray.add(json);
        }
        mode.addObject("namesHasPoten", jsonArray.toString());
        String agent=request.getHeader("User-Agent").toLowerCase();
        //如果是ie内核,返回简版页面
        if(agent != null && agent.contains("ie")){
            mode.setViewName("main/index4ie");
        }else{
            mode.setViewName("main/index");
        }
        return mode;
    }
    
    @RequestMapping("/search/previewPotentialsFile")
    @ResponseBody
    public void previewPotentialsFile(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> result =  Maps.newHashMap();
        String potentialsFileId = request.getParameter("potentialsFileId");
        TPotentialsFile fileMeta = interPotenService.getPotentialsFileMetaById(potentialsFileId);
        String suffix = CommonUtils.getFileSuffix(fileMeta.getcFileName());
        File file = null;
        try {
            file = File.createTempFile("potenFile", suffix);
            String remote = fileMeta.getRemote();
            ftpService.setLocal(file);
            ftpService.setRemote(remote);
            ftpService.download();
            String fileText = FileUtils.readFileToString(file, "utf-8");
            fileText = CommonUtils.StringToHTML(fileText); 
            result.put("success", true);
            result.put("fileText", fileText);
            result.put("fileName", fileMeta.getcFileName());
            LOG.info(fileText);
        } catch (Exception e) {
            LOG.error("获取势数据文件内容出错！ftpPath:{},fileName:{}",fileMeta.getcFtpUrlPath() ,fileMeta.getcFileName(), e);
            result.put("success", false);
            result.put("msg", "获取势数据文件内容出错！");
        }finally{
            FileUtils.deleteQuietly(file);
        }
        this.writeAjaxObject(response, result);
    }
    
    
    private String getBrowserName(String agent) {
        if(agent.indexOf("msie 7")>0){
         return "ie7";
        }else if(agent.indexOf("msie 8")>0){
         return "ie8";
        }else if(agent.indexOf("msie 9")>0){
         return "ie9";
        }else if(agent.indexOf("msie 10")>0){
         return "ie10";
        }else if(agent.indexOf("msie")>0){
         return "ie";
        }else if(agent.indexOf("opera")>0){
         return "opera";
        }else if(agent.indexOf("opera")>0){
         return "opera";
        }else if(agent.indexOf("firefox")>0){
         return "firefox";
        }else if(agent.indexOf("webkit")>0){
         return "webkit";
        }else if(agent.indexOf("gecko")>0 && agent.indexOf("rv:11")>0){
         return "ie11";
        }else{
         return "Others";
        }
       }
}
