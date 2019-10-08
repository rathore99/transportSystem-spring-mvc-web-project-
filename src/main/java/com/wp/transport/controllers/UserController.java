package com.wp.transport.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wp.transport.entities.User;
import com.wp.transport.services.UserServices;

@Controller
public class UserController {
	@Autowired
	UserServices userService;

	@RequestMapping(value="signup" ,method=RequestMethod.GET)
	public String showSignupForm() {
		return "signup";

	}
	@RequestMapping(value="login11" ,method=RequestMethod.GET)
	public String showLoginForm(Model model) {
		
		return "login";

	}
	@RequestMapping(value="saveuser", method=RequestMethod.POST)
	public ModelAndView saveUser(@Valid @ModelAttribute("user1") User user,BindingResult result, @RequestParam("userImg") MultipartFile imgFile) {

		if(result.hasErrors()) {
			ModelAndView modelAndVew = new ModelAndView("signup");
			modelAndVew.addObject("errors", "Please provide required values");
			return modelAndVew;
		}
		userService.addUser(user);
		ModelAndView modelAndVew = new ModelAndView("customerInfo");
		return modelAndVew;

	}
}
