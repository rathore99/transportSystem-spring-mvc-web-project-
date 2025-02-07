package com.wp.transport.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wp.transport.dao.DealDAO;
import com.wp.transport.entities.Deal;
import com.wp.transport.entities.Transporter;
import com.wp.transport.entities.Vehicle;
import com.wp.transport.services.TransporterService;
import com.wp.transport.services.VehicleService;
import com.wp.transport.util.Util;

@Controller
@RequestMapping("transporter/")
public class TransporterController {

	@Autowired
	TransporterService transporterService;
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	DealDAO dealDAO;
	private static final String UPLOADED_FOLDER = "D:\\images\\";

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), true, 10));
	}

	@RequestMapping(value = "saveTransporter", method = RequestMethod.POST)
	public ModelAndView saveTransporter(@Valid @ModelAttribute("transporter") Transporter transporter,
			BindingResult result, @RequestParam("gstPaperfile") MultipartFile gstPaper,
			@RequestParam("panCardfile") MultipartFile panCard) {

		if (result.hasErrors()) {
			ModelAndView modelAndVew = new ModelAndView("transporter/registerationForm");
			modelAndVew.addObject("errors", "Please provide required values");
			modelAndVew.addObject("result", result);
			return modelAndVew;
		}

		if (gstPaper.isEmpty()) {
			ModelAndView modelAndVew = new ModelAndView("transporter/registerationForm");
			modelAndVew.addObject("errors", "Please upload files");
			return modelAndVew;

		}

		try {

			// Get the file and save it somewhere
			byte[] bytes = gstPaper.getBytes();
			String fileName = gstPaper.getOriginalFilename();
			String ext = fileName.substring(fileName.lastIndexOf('.'));
			Path path = Paths.get(UPLOADED_FOLDER + Util.generateUniqueFileName() + ext);
			Files.write(path, bytes);
			transporter.setGstPaper(path.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}
        try {
			byte [] hash = Util.getSHA(transporter.getPassword());
			String hshpassword = Util.toHexString(hash);
			transporter.setPassword(hshpassword);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		transporterService.addTransporter(transporter);
		System.out.println(transporter);
		ModelAndView modelAndVew = new ModelAndView("redirect:successMsg");
		return modelAndVew;
	}

	@RequestMapping(value = "successMsg")
	public String showMsg() {
		return "transporter/successMsg";
	}
	@RequestMapping(value = "saveVehicle", method = RequestMethod.POST)
	public ModelAndView saveVehicle(@Valid @ModelAttribute("vehicle") Vehicle vehicle,
			 BindingResult result,
			@RequestParam("insurancePapers") MultipartFile insurancePaper,
			@RequestParam("fitnesscerts") MultipartFile fitnessCertficate,HttpSession session) {

		if (result.hasErrors()) {
			ModelAndView modelAndVew = new ModelAndView("transporter/VehicleForm");
			modelAndVew.addObject("errors", "Please provide required values");
			modelAndVew.addObject("result", result);
			return modelAndVew;
		}

		if (insurancePaper.isEmpty()) {
			ModelAndView modelAndVew = new ModelAndView("transporter/VehicleForm");
			modelAndVew.addObject("errors", "Please upload files");
			return modelAndVew;

		}

		try {

			// Get the file and save it somewhere
			byte[] bytes = insurancePaper.getBytes();
			String fileName = insurancePaper.getOriginalFilename();
			String ext = fileName.substring(fileName.lastIndexOf('.'));
			Path path = Paths.get(UPLOADED_FOLDER + Util.generateUniqueFileName() + ext);
			Files.write(path, bytes);
			vehicle.setInsurancePaper(path.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}
		int id = (Integer) session.getAttribute("transporterId");
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+id);
		vehicle.setTransporter(new Transporter(id));
		vehicleService.addVehicle(vehicle);
		System.out.println(vehicle);
		ModelAndView modelAndVew = new ModelAndView("transporter/successMsg");
		modelAndVew.addObject("msg", "vehicle added successfully");
		return modelAndVew;
	}

	@RequestMapping(value = "verifytransporter", method = RequestMethod.POST)
	public ModelAndView verifyTransporter(@RequestParam("email") String email,
			@RequestParam("password") String password, HttpSession session) {
		String hashPassword=null;
		try {
			byte [] hash = Util.getSHA(password);
			 hashPassword = Util.toHexString(hash);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Transporter transporter = transporterService.getTransporter(email, hashPassword);
		if (transporter != null) {
			ModelAndView modelAndView = new ModelAndView("transporter/transporterHome");
			modelAndView.addObject("transporter", transporter);
			session.setAttribute("email", email);
			session.setAttribute("transporterId", transporter.getTransporterId());
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("transporter/login");
		modelAndView.addObject("error", "Invalid Credentials");
		return modelAndView;
	}

	@RequestMapping(value = "updateProfile")
	public ModelAndView updateTransporter(HttpSession session ) {
      
		int id = (Integer) session.getAttribute("transporterId");
		System.out.println(id);
		
		Transporter transporter =  transporterService.getTransporterById(id);
		System.out.println(transporter);
		if (transporter != null) {
			ModelAndView modelAndView = new ModelAndView("transporter/updateTransporter");
			modelAndView.addObject("transporter", transporter);
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("transporter/login");
		modelAndView.addObject("error", "Invalid Credentials");
		return modelAndView;
	}  

	@RequestMapping(value = "updatevehicle")
	public ModelAndView updateVehicle(@RequestParam("registrationNo") String registrationNo) {
		
		System.out.println("registrationNo@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+registrationNo);
		Vehicle vehicle = vehicleService.getVehicle(registrationNo);
		if (vehicle == null) {
			ModelAndView modelAndView = new ModelAndView("transporter/transporterHome");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("transporter/updateVehicle");
		modelAndView.addObject("vehicle", vehicle);
		return modelAndView;
	}

	@RequestMapping(value = "updateTransporter", method = RequestMethod.POST)
	public ModelAndView updateRecord(@ModelAttribute("transporter") Transporter transporter) {

		System.out.println("!!!!update@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(transporter);
		
		transporterService.updateTransporter(transporter);
		ModelAndView modelAndView = new ModelAndView("transporter/transporterHome");
		modelAndView.addObject("msg", "record updated");
		return modelAndView;
	}

	@RequestMapping(value = "updatevehiclerecord", method = RequestMethod.POST)
	public ModelAndView updateRecord(@ModelAttribute("vehicle") Vehicle vehicle) {

		vehicleService.updateVehicle(vehicle);
		ModelAndView modelAndView = new ModelAndView("transporter/transporterHome");
		modelAndView.addObject("msg", " vehicle record updated");
		return modelAndView;
	}

	@RequestMapping("addVehicle")
	public ModelAndView showVehicleForm() {
		ModelAndView modelAndView = new ModelAndView("transporter/VehicleForm");
		modelAndView.addObject("vehicle", new Vehicle());
		return modelAndView;
	}

	@RequestMapping("login")
	public String loginPage() {
		return "login";
	}

	@RequestMapping("showVehicles")
	public ModelAndView fetchVehicles(@ModelAttribute("transporter") Transporter transporter) {

		List<Vehicle> data = vehicleService.show(transporter.getTransporterId());
		ModelAndView modelAndView = new ModelAndView("transporter/showVehicles");
		modelAndView.addObject("vehicleList", data);
		modelAndView.addObject("vehicle", new Vehicle());

		return modelAndView;
	}

	@RequestMapping("showDeals")
	public ModelAndView fetchDeales() {
		// select * from deals where transporter id= tid;
		// fetch all deals associated with transporter
		List<Deal> data = dealDAO.getDealList();
		ModelAndView modelAndView = new ModelAndView("transporter/showDeals");
		modelAndView.addObject("dealList", data);
		modelAndView.addObject("deal", new Deal());

		return modelAndView;
		
	}

	@RequestMapping("index")
	public String indexPage() {
		return "index1";
	}

	@RequestMapping("homeTransporter")
	public String homePage() {
		return "transporter/homeTransporter";
	}

}
