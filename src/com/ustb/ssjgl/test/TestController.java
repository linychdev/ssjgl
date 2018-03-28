package com.ustb.ssjgl.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController{
	@RequestMapping("/test")
    public String hello(Model model, int id, String name){
        System.out.println("--exe--"+id+name);
        model.addAttribute("message", "name=" + name + ",id=" + id);
        return "index";
        
    }
}
