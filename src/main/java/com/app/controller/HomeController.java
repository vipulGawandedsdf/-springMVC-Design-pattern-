package com.app.controller;

 

import java.util.List;

import javax.jws.WebParam.Mode;
import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.User;
import com.app.serviceImpl.Homeservice;

@Controller
public class HomeController {

	@Autowired
	private Homeservice homeservice;
	
	@RequestMapping("/")
	public String landingpage()
	{
		
		return "login";
	}
	
	
	
	@RequestMapping("/registrationPage")
	public String registerpage()
	{
		
	 
		return  "registration";
	}
	
	
	@RequestMapping("/register")
	public String saveUser(@ModelAttribute User user, ModelMap map){
		System.out.println(user.getName());
		System.out.println(user.getUname());
		System.out.println(user.getPassword());
		    int id= homeservice.saveUser(user);
		    if(id>0)
		    {
		    	map.addAttribute("msg","user added successfully");
		    	return "login";
		    }
		    else
		    {
		    	return "registration";
		    }	 
	}
	@RequestMapping("/login")
	 public String logincheck(@RequestParam String uname , @RequestParam String password,ModelMap map)
	 {
		   
		       int id= homeservice.logincheck(uname, password);
		 
		          if(id>0)
		          {
		        	   List<User>   list= homeservice.getAllUsers();
		        	     for (User user : list) {
		        	    	 System.out.println(user.getUid());
							System.out.println(user.getName());
							System.out.println(user.getUname());
							System.out.println(user.getPassword());
						}
		        	  
		        	  
		        	  map.addAttribute("userList",list);
		        	  return "success";
		          }
		          else
		          {
		        	  map.addAttribute("msg","Invalid Input");
		        	  return "login";
		          }
		 
		 
		 
	 
		 
	}
	
	@RequestMapping("/forget")
	public String forgetpassword()
	{
		return "forget";
	}
	
	
	@RequestMapping("/change")
	public String changepassword(@RequestParam String uname, @RequestParam String password ,@RequestParam String newpw , 
			@RequestParam String reEnterpw,Model map)
	{
		System.out.println("name="+uname);
		System.out.println("password="+password);
		System.out.println(newpw);
		System.out.println(reEnterpw);
		       int id=(int)homeservice.changepassword(uname, password, newpw, reEnterpw);
		       if(id>0)
		       {
		    	   map.addAttribute("msg","Change password successfully.....");
		    	   return "login"; 
		       }
		       
		       else {
		    	   map.addAttribute("msg","Not Change password .....");
		    	   return "forget";
		       }
		       
		 
	}
	
	@RequestMapping("/data")
	public String userdata(@RequestParam String uname , Model map) {

		     User user=  homeservice.userdata(uname);
		
		           System.out.println(user.getName());
		           System.out.println(user.getUname());
		           System.out.println(user.getPassword());
		        
		       map.addAttribute("msg", user);
		return  "userinfo";
	}
	
 
	
	@RequestMapping("/delete/{uid}")
	public String deleteuser(@PathVariable("uid") int uid, ModelMap map)
	{
		
		 List<User> user1=  homeservice.deleteuser(uid);
		 
		 map.addAttribute("userList", user1);
		
		return"success";
	}
	
	@RequestMapping("/edit/{uid}")
	public String editUser(@PathVariable("uid") int uid, ModelMap map)
	{
		User user = homeservice.editUser(uid);
		map.addAttribute("data", user);
		return "edit";
		
	}
	
	@RequestMapping("/update")
	public String updateuser(@ModelAttribute User user,ModelMap map)
	{
		List<User> list1 = homeservice.updateuser(user);
	map.addAttribute("userList", list1);
	return "success";
		
	}
	
	@RequestMapping("/logout")
	public String logout()
	{
		return "login";
	}
	
	
}
