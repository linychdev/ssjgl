package com.ustb.ssjgl.main.action;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

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

import com.ustb.ssjgl.common.action.AbstractAction;
import com.ustb.ssjgl.common.utils.CommonUtils;
import com.ustb.ssjgl.common.utils.LogUtils;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFile;
import com.ustb.ssjgl.main.service.IInterPotenService;
import com.ustb.ssjgl.main.service.impl.FtpService;

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
    
    @RequestMapping(value = "/search/list/{tag}", method=RequestMethod.GET)
    public ModelAndView getElementCombList(@PathVariable(value = "tag") String tag) {
        interPotenService.getInterPotenListByTag(tag);
        
        ModelAndView mode = new ModelAndView();
        mode.setViewName("elementCombList");
        mode.addObject("msg", "hello kitty");
        return mode;
    }  
    
    /**
     * 下载势文件
     * @param request
     * @param response
     */
    @RequestMapping(value="/manage/downloadPotentialsFile")
    @ResponseBody
    public ResponseEntity<byte[]> downloadPotenFile(HttpServletRequest request, HttpServletResponse response) {
        String potentialsId = request.getParameter("potentialsId");
        TPotentialsFile fileMeta = interPotenService.getPotentialsFileMetaByCombId(potentialsId);
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
}
