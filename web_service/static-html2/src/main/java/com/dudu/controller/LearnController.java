package com.dudu.controller;


import com.dudu.domain.Jail;
import com.dudu.domain.LearnResouce;
import com.dudu.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * Created by tengj on 2017/3/13.
 */
@Controller
public class LearnController {

	@Autowired
	private RestTemplate restTemplate;
	
	
    @RequestMapping(value = "/post_login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> login(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map =new HashMap<String,Object>();
        String account=request.getParameter("account");
        String password=request.getParameter("password");
        if(!account.equals("") && password!=""){
            User user =new User(account,password);
            request.getSession().setAttribute("user",user);
            map.put("result","1");
        }else{
            map.put("result","0");
        }
        return map;
    }

    
    @RequestMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("mainPage");
        return modelAndView;
    }
    
    @RequestMapping("/prisoner_info")
    public ModelAndView prisoner_info(){
        ModelAndView modelAndView = new ModelAndView("prisoner_info");
        return modelAndView;
    }
    

    
    @RequestMapping("/manager_info")
    public ModelAndView manager_info(){
        ModelAndView modelAndView = new ModelAndView("manager_info");
        return modelAndView;
    }
    
    
    @RequestMapping("/jail_info")
    public ModelAndView jail_info(){
        ModelAndView modelAndView = new ModelAndView("jail_info");       
        return modelAndView;
    }
    @RequestMapping("/get/jail_info/jail_number={id}")
    public ModelAndView visitor_info(@PathVariable String id)
    {  	
    	List<Jail> jailList =new ArrayList<Jail>();
    	Jail p = restTemplate.getForObject("http://localhost:8761/get/jail/jail_number=" + id, Jail.class);
    	jailList.add(p); 
        System.out.println("NAME = " + p.jail_number.toString());
        ModelAndView modelAndView = new ModelAndView("jail_info");
        modelAndView.addObject("data_list", jailList);
        return modelAndView;
    }
    
    
    @RequestMapping("/learn")
    public ModelAndView index(){
        List<LearnResouce> learnList =new ArrayList<LearnResouce>();
        LearnResouce bean =new LearnResouce("官方参考文档","Spring Boot Reference Guide","http://docs.spring.io/spring-boot/docs/1.5.1.RELEASE/reference/htmlsingle/#getting-started-first-application");
        learnList.add(bean);
        bean =new LearnResouce("官方SpriongBoot例子","官方SpriongBoot例子","https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples");
        learnList.add(bean);
        bean =new LearnResouce("龙国学院","Spring Boot 教程系列学习","http://www.roncoo.com/article/detail/125488");
        learnList.add(bean);
        bean =new LearnResouce("嘟嘟MD独立博客","Spring Boot干货系列 ","http://tengj.top/");
        learnList.add(bean);
        bean =new LearnResouce("后端编程嘟","Spring Boot教程和视频 ","http://www.toutiao.com/m1559096720023553/");
        learnList.add(bean);
        bean =new LearnResouce("程序猿DD","Spring Boot系列","http://www.roncoo.com/article/detail/125488");
        learnList.add(bean);
        bean =new LearnResouce("纯洁的微笑","Sping Boot系列文章","http://www.ityouknow.com/spring-boot");
        learnList.add(bean);
        bean =new LearnResouce("CSDN——小当博客专栏","Sping Boot学习","http://blog.csdn.net/column/details/spring-boot.html");
        learnList.add(bean);
        bean =new LearnResouce("梁桂钊的博客","Spring Boot 揭秘与实战","http://blog.csdn.net/column/details/spring-boot.html");
        learnList.add(bean);
        bean =new LearnResouce("林祥纤博客系列","从零开始学Spring Boot ","http://412887952-qq-com.iteye.com/category/356333");
        learnList.add(bean);
        ModelAndView modelAndView = new ModelAndView("/template");
        modelAndView.addObject("learnList", learnList);
        return modelAndView;
    }
    
    
    
    
    
}
