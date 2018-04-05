package com.ustb.ssjgl.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ustb.ssjgl.common.log.annotation.VisitLog;
import com.ustb.ssjgl.common.log.annotation.VisitLogType;
import com.ustb.ssjgl.dao.impl.TestDao;
import com.ustb.ssjgl.dao.pojo.TTestLin;

@Controller
public class TestController{
    
    @Autowired
    private TestDao testDao;
    
    @VisitLog(VisitLogType.SEARCH)
	@RequestMapping("/test")
    public ModelAndView hello(){
        TTestLin testTable = testDao.getTestByBh();
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName( "index" );
        modelAndView.addObject( "message" , "name=" + testTable.getcName() + ",password=" + testTable.getcPassword() );
       return modelAndView;
    }
}
