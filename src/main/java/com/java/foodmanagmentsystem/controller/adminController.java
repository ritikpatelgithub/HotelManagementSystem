package com.java.foodmanagmentsystem.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.foodmanagmentsystem.dao.AdminDao;
import com.java.foodmanagmentsystem.entity.Admin;
import com.java.foodmanagmentsystem.entity.Hotel;


@Controller
public class adminController {
	@Autowired
	AdminDao dao;
	
	@RequestMapping("/addadmin")
	//
	public ModelAndView addAdmin() {
		Admin admin=new Admin();
		ModelAndView mav=new ModelAndView();
		mav.addObject("adminobj",admin);
		mav.setViewName("adminform");
		return mav;
	}
	
	@RequestMapping("saveadmin")
	//Handler used to save details into the database
	public ModelAndView saveAdmin(@ModelAttribute("adminobj") Admin admin) {
		dao.saveAdmin(admin);
		ModelAndView mav=new ModelAndView();
		mav.addObject("message", "account Created Successfully");
		mav.setViewName("adminlogin");
		return mav;
	}
	@RequestMapping("/adminloginvalidate")
	//HAndler used to perform Login validation for admin
	public ModelAndView loginValidate(ServletRequest request,HttpSession session) {
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		Admin admin=dao.login(email, password);
		ModelAndView mav=new ModelAndView();
		
		if(admin!=null) {
			mav.setViewName("adminoptions");
			session.setAttribute("admininfo", admin);
			return mav;
		}
		else {
			mav.addObject("message","invalid credentials");
			mav.setViewName("adminlogin");
			return mav;
		}
	}
	
	
	
	

}
