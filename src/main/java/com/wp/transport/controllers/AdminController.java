package com.wp.transport.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.wp.transport.entities.Deal;
import com.wp.transport.entities.Transporter;
import com.wp.transport.entities.Vehicle;
import com.wp.transport.services.TransporterService;
import com.wp.transport.services.VehicleService;

@Controller
public class AdminController {
	@Autowired
	TransporterService transporterService ;
	@Autowired
	VehicleService vehicleService; 

	
	/****************************sshow admin home**************************/
	@RequestMapping("admin/adminhome")
	public ModelAndView adminHome()
	{
		
		ModelAndView mv=new ModelAndView("admin/adminhome");
		
	List<Vehicle>data=	vehicleService.getUnapprovedVehicles();
	mv.addObject("vehicleList", data);
		return mv;
	}
	
	/***********************show all transporters************************************/
	@RequestMapping("viewalltransporteradmin")
	public ModelAndView viewAllTransporter()
	{
		//List<Transporter> transporter=transporterService.showAllTransporterService();
		ModelAndView mv=new ModelAndView("showalltransportertoadmin");
		//mv.addObject("transporter", transporter);
		
		return mv;
	}
	@RequestMapping("admin/showVehicles")
	public ModelAndView fetchVehicles() {

		List<Vehicle> data = vehicleService.show();
		ModelAndView modelAndView = new ModelAndView("transporter/showVehicles");
		modelAndView.addObject("vehicleList", data);
		modelAndView.addObject("vehicle", new Vehicle());

		return modelAndView;
	}

	/*
	@RequestMapping("viewallDealadmin")
	public ModelAndView viewAllDeal()
	{
		List<Deal> deal=transporterService.showAllDealToService();
		ModelAndView mv=new ModelAndView("AdminViewAllDeal");
		mv.addObject("deal", deal);
		
		return mv;
	}
	
	
	@RequestMapping("approvetransporterrequest")
	public ModelAndView seeApproveTransporterRequest()
	{
		List<Transporter> transporter=transporterService.showAllTransporterNotApprovedService();
		
		ModelAndView mv=new ModelAndView("approvetransporterrequest");
		mv.addObject("transporter", transporter);
		
		return mv;
	}
	
	@RequestMapping("approveVehicleRequest")
	public ModelAndView seeApproveVehicleRequest()
	{
		List<Vehicle> vehicle=transporterService.showAllVehicleNotApprovedService();
		
		ModelAndView mv=new ModelAndView("AdminApprovedVehicle");
		mv.addObject("vehicle", vehicle);
		
		return mv;
	}
	
	@RequestMapping("approveVehicle")
	public ModelAndView approveVehicleRequest(@RequestParam ("number") String number)
	{
		transporterService.approveVehicleByAdminService(number);
		ModelAndView mv=new ModelAndView("adminhome");
		return mv;
	}
	
	
	@RequestMapping("approvetransporter")
	public ModelAndView approveTransporterRequest(@RequestParam ("email") String email)
	{
		transporterService.approveTransporterService(email);
		ModelAndView mv=new ModelAndView("adminhome");
		return mv;
	}
	
	@RequestMapping("removeDealByAdmin")
	public ModelAndView deleteDeal(@RequestParam ("id") int id,@RequestParam ("email") String email)
	{
		transporterService.deleteDealByAdminService(id, email);
		ModelAndView mv=new ModelAndView("adminhome");
		return mv;
	}
	
	
	@RequestMapping("viewAllQueryAndResponse")
	public ModelAndView viewAllQueryAndResponse(){
	
		//List<Deal> deal =customerService.ShowDealSoryByCityCustomerDeal(cityname);
		List<QueryClass> response=transporterService.showAllCustomerQueryAndTransporterResponseService();	
		ModelAndView mv=new ModelAndView("showqueryresponse");
		mv.addObject("response", response);
		return mv;
	}
	
	
	@RequestMapping("viewadmin")
	public void viewTransporterData(@RequestParam("code") String name,HttpServletResponse response) throws IOException{
		
		File f = new File(name);
		FileInputStream fis = new  FileInputStream(f);
		byte b[]=new byte[fis.available()];
		fis.read(b);
		ServletOutputStream sos = response.getOutputStream();
		sos.write(b);
		sos.close();  
		}	
	*/
}
