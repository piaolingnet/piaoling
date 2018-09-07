package com.piaoling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mr-Wang on 2017/9/9.
 */
@Controller
@RequestMapping("/testController")
public class Test1 {
	
	
    @RequestMapping("/getTest")
    @ResponseBody
    public ModelAndView getTest(HttpServletRequest request){
    	/*News news=newsService.getNewsByPrimaryKey("1");
    	System.out.println("新闻查询entity"+news.getNewsTitle());*/
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
    
    @RequestMapping("/index")
    public String getindex(HttpServletRequest request){
        return "index/index";
    }
}
