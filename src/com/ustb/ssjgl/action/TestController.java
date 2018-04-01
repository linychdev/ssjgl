package com.ustb.ssjgl.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ustb.ssjgl.common.log.annotation.VisitLog;
import com.ustb.ssjgl.common.log.annotation.VisitLogType;

@Controller
public class TestController{
    @VisitLog(VisitLogType.SEARCH)
	@RequestMapping("/test")
    public ModelAndView hello(Model model, int id, String name){
	       ModelAndView modelAndView = new ModelAndView();
	       modelAndView.setViewName( "index" );
	       modelAndView.addObject( "message" , "name=" + name + ",idss=" + id );
	       return modelAndView;
//        System.out.println("--exe--"+id+name);
//        model.addAttribute("message", "name=" + name + ",id=" + id);
//        return "index";
    }
}
