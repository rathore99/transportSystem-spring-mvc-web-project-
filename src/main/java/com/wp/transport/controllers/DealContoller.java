package com.wp.transport.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wp.transport.entities.Deal;
import com.wp.transport.entities.Transporter;
import com.wp.transport.entities.Vehicle;
import com.wp.transport.services.DealService;
import com.wp.transport.services.VehicleService;

@Controller
public class DealContoller {
	
	@Autowired
	VehicleService vehicleService;
	@Autowired
	DealService dealService;
	

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), true, 10));
	}

	@RequestMapping("transporter/postDeal")
	public ModelAndView createDeal(Model model,HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("deals/dealForm");
		if(!model.containsAttribute("deal")) {
			model.addAttribute("deal", new Deal());
		}
		int tid = (Integer) session.getAttribute("transporterId");
		List<String>vehicleList = vehicleService.getAllvehicle(tid);
		for(String v:vehicleList) {
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println(v);
		}
		modelAndView.addObject("vehicleList",vehicleList);
		return modelAndView;
	}
	
	@RequestMapping("transporter/createDeal")
	public ModelAndView saveDeal(@Valid @ModelAttribute("deal") Deal deal,@RequestParam("registrationNo") String vehicleNo,BindingResult result,HttpSession session) {
		if(result.hasErrors()) {
			ModelAndView modelAndVew = new ModelAndView("dealForm");
			modelAndVew.addObject("errors", "Please provide required values");
			return modelAndVew;
		}
		int id = (Integer) session.getAttribute("transporterId");
		deal.setTransporter(new Transporter(id));
		deal.setVehicle(new Vehicle(vehicleNo));
		if(dealService.addDeal(deal)) {
		ModelAndView modelAndView = new ModelAndView("transporter/transporterHome");
		modelAndView.addObject("msg","Deal Posted successully!!!");
		System.out.println(deal);
		return modelAndView;
		}
		
		ModelAndView modelAndView = new ModelAndView("deals/dealForm");
		modelAndView.addObject("msg","error occured");
		return modelAndView;
	}

}
