package com.wp.transport.controllers;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wp.transport.services.CustomerService;
import com.wp.transport.services.TransporterService;
import com.wp.transport.util.Util;

@Controller
public class LoginController {
	@Autowired
	CustomerService customerServices;
	@Autowired
	TransporterService transporterServices;
	
	
	
	
	
	@RequestMapping(value="customer/forgotPassword", method = RequestMethod.GET)
	public ModelAndView forgotPasswordForm() {
		ModelAndView modelAndView = new ModelAndView("customer/forgotPassword");
		return modelAndView;
	}

	@RequestMapping(value="customer/homePage", method = RequestMethod.GET)
	public ModelAndView homepage() {
		ModelAndView modelAndView = new ModelAndView("customer/homePage");
		return modelAndView;
	}
	
	@RequestMapping(value="customer/verify", method = RequestMethod.POST)
	public ModelAndView verifyUser(@RequestParam("email") String email,@RequestParam("password") String password,HttpSession session) {
		String hashPassword=null;
		try {
			byte [] hash = Util.getSHA(password);
			 hashPassword = Util.toHexString(hash);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(customerServices.getCustomer(email, hashPassword)) {
		ModelAndView modelAndView = new ModelAndView("redirect:homePage");
		session.setAttribute("customer", email);
		return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("customer/login");
		modelAndView.addObject("error", "Invalid Credentials");
		return modelAndView;
	}
	/*
	@RequestMapping(value="verifytransporter", method = RequestMethod.POST)
	public ModelAndView verifyTransporter(@RequestParam("email") String email,@RequestParam("password") String password) {
		Transporter transporter =transporterServices.getTransporter(email, password);
		if(transporter!=null) {
		ModelAndView modelAndView = new ModelAndView("transporter/transporterHome");
		modelAndView.addObject("transporter", transporter);
		return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("transporter/login");
		modelAndView.addObject("error", "Invalid Credentials");
		return modelAndView;
	}
	*/
	@RequestMapping(value="customer/resetPassword", method = RequestMethod.POST)
	public ModelAndView sendTempPassword() {
		ModelAndView modelAndView = new ModelAndView("customer/login");
		//logic to send mail and check temporary password
		return modelAndView;
	}
	
	@RequestMapping(value="customer/logout", method = RequestMethod.GET)
	public ModelAndView logout() {
		ModelAndView modelAndView = new ModelAndView("index1");
		return modelAndView;
	}

}
