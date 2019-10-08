package com.wp.transport.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.wp.transport.entities.Transporter;
import com.wp.transport.services.CustomerService;
import com.wp.transport.services.TransporterService;

@Controller
public class LoginController {
	@Autowired
	CustomerService customerServices;
	@Autowired
	TransporterService transporterServices;
	
	
	
	
	
	@RequestMapping(value="forgotPassword", method = RequestMethod.GET)
	public ModelAndView forgotPasswordForm() {
		ModelAndView modelAndView = new ModelAndView("forgotPassword");
		return modelAndView;
	}
	
	@RequestMapping(value="verify", method = RequestMethod.POST)
	public ModelAndView verifyUser(@RequestParam("email") String email,@RequestParam("password") String password) {
		
		if(customerServices.getCustomer(email, password)) {
		ModelAndView modelAndView = new ModelAndView("homePage");
		return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("login");
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
	@RequestMapping(value="resetPassword", method = RequestMethod.POST)
	public ModelAndView sendTempPassword() {
		ModelAndView modelAndView = new ModelAndView("login");
		//logic to send mail and check temporary password
		return modelAndView;
	}
	
	@RequestMapping(value="logout", method = RequestMethod.GET)
	public ModelAndView logout() {
		ModelAndView modelAndView = new ModelAndView("index1");
		return modelAndView;
	}

}
