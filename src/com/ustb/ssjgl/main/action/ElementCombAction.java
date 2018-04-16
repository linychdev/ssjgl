package com.ustb.ssjgl.main.action;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ustb.ssjgl.common.action.AbstractAction;
import com.ustb.ssjgl.common.utils.LogUtils;
import com.ustb.ssjgl.main.bean.InteratomicPotentials;
import com.ustb.ssjgl.main.service.IElementCombService;

/**
 * ElementCombAction
 * @author linych
 * @version 1.0
 *
 */
@Controller
public class ElementCombAction extends AbstractAction{
    
    /**
     * logger
     */
    private final static Logger LOG = LogUtils.getLogger();

    private IElementCombService elementCombService;
    
    /**
     * 获取服务目录
     * 
     * @param request
     * @param response
     */
    @RequestMapping("/manage/addPotentials")
    @ResponseBody
    public void getServiceDirectory(@RequestBody String json,HttpServletResponse response) {
        
        JSONObject jasonObject = null;
        try{
             jasonObject = JSONObject.parseObject(json);
        }catch(Exception e){
            throw new RuntimeException("无法解析的json！"+e.getMessage());
        }
        
        InteratomicPotentials interPoten = new InteratomicPotentials(jasonObject);
        
        
//        this.writeAjaxString(response, datService.getServiceDirectory(json));
    }
    
}
