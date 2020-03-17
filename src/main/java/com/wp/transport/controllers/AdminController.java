package com.wp.transport.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wp.transport.entities.Transporter;
import com.wp.transport.entities.Vehicle;
import com.wp.transport.services.TransporterService;
import com.wp.transport.services.VehicleService;
import com.wp.transport.util.Util;

@Controller
@RequestMapping("admin/")
public class AdminController {
	@Autowired
	TransporterService transporterService;
	@Autowired
	VehicleService vehicleService;

	@Autowired
	JavaMailSender mailSender;

	/**************************** sshow admin home **************************/
	@RequestMapping("adminhome")
	public ModelAndView adminHome() {

		ModelAndView mv = new ModelAndView("admin/adminhome");
		List<Transporter> transporterData = transporterService.getTransporterByStatus(false);
		List<Vehicle> data = vehicleService.getUnapprovedVehicles(false);
		mv.addObject("heading", "Unapproved transporter list");
		mv.addObject("vehicleList", data);
		mv.addObject("headingv", "Unapproved vehicle list");
		mv.addObject("transporterList", transporterData);
		return mv;
	}
	@RequestMapping("approveVehicleRequest")
	public ModelAndView approvedVehicles() {

		ModelAndView mv = new ModelAndView("admin/adminhome");
		List<Transporter> transporterData = transporterService.getTransporterByStatus(true);
		List<Vehicle> data = vehicleService.getUnapprovedVehicles(true);
		mv.addObject("vehicleList", data);
		mv.addObject("heading", "approved transporter list");
		mv.addObject("headingv", "Unapproved vehicle list");
		mv.addObject("transporterList", transporterData);
		return mv;
	}


	/************************approoved transporters********************************/
	@RequestMapping("approvetransporterrequest")
	public ModelAndView approvedTransporters() {

		ModelAndView mv = new ModelAndView("admin/adminhome");
		List<Transporter> transporterData = transporterService.getTransporterByStatus(true);
		List<Vehicle> data = vehicleService.getUnapprovedVehicles(false);
		mv.addObject("vehicleList", data);
		mv.addObject("heading", "approved transporter list");
		mv.addObject("headingv", "Unapproved vehicle list");
		mv.addObject("transporterList", transporterData);
		return mv;
	}
	


	/****************************
	 * sing detail page
	 *********************************/
	@RequestMapping("viewTransporterDetails")
	public ModelAndView showTransporter(@ModelAttribute("transporterId") int transporterId) {
		ModelAndView mv = new ModelAndView("admin/showTransporter");
		Transporter transporter = transporterService.getTransporterById(transporterId);
		mv.addObject("transporter", transporter);
		return mv;

	}
	
	/**************************** Request accepted ****************************/

	@RequestMapping("acceptRequest")
	public ModelAndView updateStatus(@ModelAttribute("transporterId") int transporterId) {
		ModelAndView mv = new ModelAndView("redirect:adminhome");
		Transporter transporter = transporterService.getTransporterById(transporterId);
		transporter.setStatus(true);
		Util util = new Util();
		System.out.println(transporter.getEmail() + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(transporter.getEmail());
		mailMessage.setSubject("request accepted ");
		mailMessage.setText("your account veriied.... please login  at www.wp.transport.com");
		try {
			mailSender.send(mailMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// util.sendMail(transporter.getEmail(), "Account verified", "your account
		// veriied.... please login");
		transporterService.updateTransporter(transporter);
		mv.addObject("transporter", transporter);
		return mv;

	}

	/**************************** Request Decline ****************************/

	@RequestMapping("declineRequest")
	public ModelAndView deleteAccount(@ModelAttribute("transporterId") int transporterId) {
		ModelAndView mv = new ModelAndView("redirect:adminhome");
		Transporter transporter = transporterService.getTransporterById(transporterId);
		Util util = new Util();
		System.out.println(transporter.getEmail() + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(transporter.getEmail());
		mailMessage.setSubject("account request decline");
		mailMessage.setText("your request is not approved by admin. Please do register with proper documents");
		try {
			mailSender.send(mailMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// util.sendMail(transporter.getEmail(), "Account verified", "your account
		// veriied.... plaease login");
		transporterService.deleteTransporter(transporter);
		mv.addObject("msg", "deleted successfully");
		return mv;

	}

	/******************************* vehicle detail *******************************/
	@RequestMapping("viewVehicleDetails")
	public ModelAndView showVehicles(@ModelAttribute("vid") String vid) {
		ModelAndView mv = new ModelAndView("admin/showVehicle");
		Vehicle vehicle = vehicleService.getVehicleById(vid);
		mv.addObject("vehicle", vehicle);
		return mv;

	}

	/********************* vehicle approved *************************/
	@RequestMapping("approveVehicle")
	public ModelAndView updateVehicleStatus(@ModelAttribute("vid") String vid) {
		ModelAndView mv = new ModelAndView("redirect:adminhome");
		Vehicle vehicle = vehicleService.getVehicleById(vid);
		vehicle.setStatus(true);
		Util util = new Util();

		int tid = vehicle.getTransporter().getTransporterId();
		Transporter transporter = transporterService.getTransporterById(tid);
		System.out.println(transporter.getEmail() + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(transporter.getEmail());
		mailMessage.setSubject("request accepted ");
		mailMessage.setText("your vehicle dos veriied. Now you can post deals.please login  at www.wp.transport.com");
		try {
			mailSender.send(mailMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// util.sendMail(transporter.getEmail(), "Account verified", "your account
		// veriied.... please login");
		vehicleService.updateVehicle(vehicle);
		mv.addObject("vehicle", vehicle);
		return mv;

	}


	/******************* vehicle not approved **********************/

	@RequestMapping("declineVehicleRequest")
	public ModelAndView deleteVehicle(@ModelAttribute("vid") String vid) {
		ModelAndView mv = new ModelAndView("redirect:adminhome");
		Vehicle vehicle = vehicleService.getVehicleById(vid);
		int tid = vehicle.getTransporter().getTransporterId();
		Transporter transporter = transporterService.getTransporterById(tid);
		Util util = new Util();
		System.out.println(transporter.getEmail() + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(transporter.getEmail());
		mailMessage.setSubject("vehicle not approved");
		mailMessage.setText("your vehicle request is not approved by admin. Please do register with proper documents");
		try {
			mailSender.send(mailMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// util.sendMail(transporter.getEmail(), "Account verified", "your account
		// veriied.... plaease login");
		vehicleService.deleteVehicle(vehicle);
		mv.addObject("msg", "deleted successfully");
		return mv;

	}

	/***********************
	 * show all transporters
	 ************************************/
	@RequestMapping("viewalltransporteradmin")
	public ModelAndView viewAllTransporter() {
		// List<Transporter> transporter=transporterService.showAllTransporterService();
		ModelAndView mv = new ModelAndView("showalltransportertoadmin");
		// mv.addObject("transporter", transporter);

		return mv;
	}

	@RequestMapping("showVehicles")
	public ModelAndView fetchVehicles() {

		List<Vehicle> data = vehicleService.show();
		ModelAndView modelAndView = new ModelAndView("transporter/showVehicles");
		modelAndView.addObject("vehicleList", data);
		modelAndView.addObject("vehicle", new Vehicle());

		return modelAndView;
	}


}
