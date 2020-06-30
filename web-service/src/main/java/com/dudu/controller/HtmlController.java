package com.dudu.controller;



import com.alibaba.fastjson.JSONArray;
import com.dudu.domain.Jail;
import com.dudu.domain.LearnResouce;
import com.dudu.domain.Manager;
import com.dudu.domain.Prisoner;
import com.dudu.domain.User;
import com.dudu.domain.VisitPerson;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * Created by tengj on 2017/3/13.
 */
@Controller
public class HtmlController {

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
    @RequestMapping("/prisoner_info2")
    public ModelAndView prisoner_info2(){
        ModelAndView modelAndView = new ModelAndView("prisoner_info2");
        return modelAndView;
    }
    
    @RequestMapping("/get/prisoner_info/file_number={id}")
    public ModelAndView prisoner_info(@PathVariable String id)
    {  	
    	List<Prisoner> jailList =new ArrayList<Prisoner>();
    	Prisoner p = restTemplate.getForObject("http://localhost:8761/get/prisoner/file_number=" + id, Prisoner.class);
    	jailList.add(p); 
    	System.out.println("name = " + p.name);
        ModelAndView modelAndView = new ModelAndView("prisoner_info");
        modelAndView.addObject("data_list", jailList);
        return modelAndView;
    }
    
    @RequestMapping("/query/prisoner_info2")
    public ModelAndView prisoner_info2(
			  @RequestParam(value = "name", required = false) String name,
			  @RequestParam(value = "sex", required = false) String sex,
			  @RequestParam(value = "birth_date", required = false) String birth_date,
			  @RequestParam(value = "blood_type", required = false) String blood_type
    		) 
    {  	
    	String query_url = new String("http://localhost:8761/query/prisoner?");
    	String param_url = new String();
    	
    	param_url += "name=" + name;
    	param_url += "&sex=" + sex;
    	param_url += "&birth_date=" + birth_date;
    	param_url += "&blood_type=" + blood_type;
    	query_url += param_url;
    	 	
    	System.out.println("query_url = "+query_url);
    		
    	String str = restTemplate.getForObject(query_url, String.class);
    	System.out.println("str = "+str);
    	  
        List<Prisoner> list = JSONArray.parseArray(str, Prisoner.class);
        System.out.println("list.size():" + list.size());
    	
    	// System.out.println("manager name = " + p.manager_name);
        ModelAndView modelAndView = new ModelAndView("prisoner_info2");
        modelAndView.addObject("data_list", list);
        return modelAndView;
    }
    
    
    
    
    @RequestMapping("/manager_info")
    public ModelAndView manager_info(){
        ModelAndView modelAndView = new ModelAndView("manager_info");
        return modelAndView;
    }
      
    
    @RequestMapping("/get/manager_info/manager_file_number={id}")
    public ModelAndView manager_info(@PathVariable String id)
    {  	
    	List<Manager> jailList =new ArrayList<Manager>();
    	Manager p = restTemplate.getForObject("http://localhost:8761/get/mamager/manager_file_number=" + id, Manager.class);
    	jailList.add(p); 
    	System.out.println("manager name = " + p.manager_name);
        ModelAndView modelAndView = new ModelAndView("manager_info");
        modelAndView.addObject("data_list", jailList);
        return modelAndView;
    }
    
    
    @RequestMapping("/manager_info2")
    public ModelAndView manager_info2(){
        ModelAndView modelAndView = new ModelAndView("manager_info2");
        return modelAndView;
    }
    @RequestMapping("/query/manager_info2")
    public ModelAndView manager_info2(
			  @RequestParam(value = "manager_name", required = false) String name,
			  @RequestParam(value = "manager_sex", required = false) String sex,
			  @RequestParam(value = "manager_birth_date", required = false) String birth_date,
			  @RequestParam(value = "manager_blood_type", required = false) String blood_type
    		) 
    {  	
    	String query_url = new String("http://localhost:8761/query/manager?");
    	String param_url = new String();
    	
    	param_url += "manager_name=" + name;
    	param_url += "&manager_sex=" + sex;
    	param_url += "&manager_birth_date=" + birth_date;
    	param_url += "&manager_blood_type=" + blood_type;
    	query_url += param_url;
    	 	
    	System.out.println("query_url = "+query_url);
    		
    	String str = restTemplate.getForObject(query_url, String.class);
    	System.out.println("str = "+str);
    	  
        List<Manager> manager_list = JSONArray.parseArray(str, Manager.class);
        System.out.println("list.size():" + manager_list.size());
    	
    	// System.out.println("manager name = " + p.manager_name);
        ModelAndView modelAndView = new ModelAndView("manager_info2");
        modelAndView.addObject("data_list", manager_list);
        return modelAndView;
    }
    

    
    
    @RequestMapping("/visitor_info")
    public ModelAndView visitor_info(){
        ModelAndView modelAndView = new ModelAndView("visitor_info");
        return modelAndView;
    }
    
    @RequestMapping("/get/visitor_info/visit_person_id={id}")
    public ModelAndView visitor_info(@PathVariable String id)
    {  	
    	List<VisitPerson> jailList =new ArrayList<VisitPerson>();
    	VisitPerson p = restTemplate.getForObject("http://localhost:8761/get/visit_person/visit_person_id=" + id, VisitPerson.class);
    	jailList.add(p); 
        System.out.println("NAME = " + p.visit_person_name.toString());
        ModelAndView modelAndView = new ModelAndView("visitor_info");
        modelAndView.addObject("data_list", jailList);
        return modelAndView;
    }
    
    
    
    @RequestMapping("/jail_info")
    public ModelAndView jail_info(){
        ModelAndView modelAndView = new ModelAndView("jail_info");       
        return modelAndView;
    }
    
    
    
    @RequestMapping("/get/jail_info/jail_number={id}")
    public ModelAndView jail_info(@PathVariable String id)
    {  	
    	List<Jail> jailList =new ArrayList<Jail>();
    	Jail p = restTemplate.getForObject("http://localhost:8761/get/jail/jail_number=" + id, Jail.class);
    	jailList.add(p); 
        System.out.println("NAME = " + p.jail_number.toString());
        ModelAndView modelAndView = new ModelAndView("jail_info");
        modelAndView.addObject("data_list", jailList);
        return modelAndView;
    }
    
    
    
    
    
    
    
    
    
    
    
}
