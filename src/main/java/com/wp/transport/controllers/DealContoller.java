package com.wp.transport.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wp.transport.services.VehicleService;
import com.wp.transport.services.VehicleServiceImpl;

@Controller
public class DealContoller {
	
	@Autowired
	VehicleService vehicleService;
	
	@RequestMapping("transporter/postDeal")
	public ModelAndView createDeal() {
		ModelAndView modelAndView = new ModelAndView("deals/dealForm");
		
		return modelAndView;
	}
	
	@RequestMapping("transporter/createDeal")
	public ModelAndView saveDeal() {
		ModelAndView modelAndView = new ModelAndView("transporter/transporterHome");
		return modelAndView;
	}

}
