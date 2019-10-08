package com.wp.transport.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.wp.transport.entities.Customer;
import com.wp.transport.entities.Transporter;

@Controller
@SessionAttributes("transporter")
public class BasicController {
	
	@RequestMapping(value="index", method = RequestMethod.GET)
	public ModelAndView showIndexPage() {
		ModelAndView modelAndView = new ModelAndView("index1");
		return modelAndView;
	}
	@RequestMapping(value= {"login"}, method = RequestMethod.GET)
	public ModelAndView showLoginForm() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	@RequestMapping(value= {"transporter/login"}, method = RequestMethod.GET)
	public ModelAndView showLoginFormT() {
		ModelAndView modelAndView = new ModelAndView("transporter/login");
		return modelAndView;
	}
	@RequestMapping(value="register", method = RequestMethod.GET)
	public ModelAndView showRegistrationForm() {
		ModelAndView modelAndView = new ModelAndView("customerRegistrationForm");
		modelAndView.addObject("customer",new Customer());
		return modelAndView;
	}

	@RequestMapping(value="transporter/register", method = RequestMethod.GET)
	public ModelAndView showRegistrationFormTr(Model model) {
		ModelAndView modelAndView = new ModelAndView("transporter/registerationForm");
		if(!model.containsAttribute("transporter")) {
			model.addAttribute("transporter", new Transporter());
		}
		modelAndView.addObject("transporter",new Transporter());
		return modelAndView;
	}
}
