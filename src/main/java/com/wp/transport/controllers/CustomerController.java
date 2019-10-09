package com.wp.transport.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wp.transport.entities.Customer;
import com.wp.transport.services.CustomerService;
import com.wp.transport.util.Util;;
@Controller
public class CustomerController {
	private static final String UPLOADED_FOLDER = "D:\\Coding\\worldpay\\TransportSystem\\src\\main\\webapp\\resources\\images\\";
	
	@Autowired
	CustomerService customerServices;
	/*
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields(new String[] {"profileImg"});
	}
	*/

	/*@RequestMapping(value="register" ,method=RequestMethod.GET)
	public ModelAndView showRegistrationForm() {
		ModelAndView modelAndView = new ModelAndView("customerRegistrationForm");
		modelAndView.addObject("customer",new Customer());
		return modelAndView;
	}
	*/
	@RequestMapping(value="saveCustomer", method=RequestMethod.POST)
	public ModelAndView saveUser(@Valid @ModelAttribute("customer") Customer customer,BindingResult result, @RequestParam("profileImgs") MultipartFile imgFile,HttpSession session) {

		if(result.hasErrors()) {
			ModelAndView modelAndVew = new ModelAndView("customerRegistrationForm");
			modelAndVew.addObject("errors", "Please provide required values");
			return modelAndVew;
		}
		/*
		byte b[] = null;
		try {
			b = imgFile.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Blob blob = BlobProxy.generateProxy(b);
		customer.setProfileImg(blob);**/
		
		if (imgFile.isEmpty()) {
			ModelAndView modelAndVew = new ModelAndView("customerRegistrationForm");
			modelAndVew.addObject("errors", "Please provide required values");
			return modelAndVew;

        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = imgFile.getBytes();
           String fileName= imgFile.getOriginalFilename();
            String ext =  fileName.substring(fileName.lastIndexOf('.'));
            Path path = Paths.get(UPLOADED_FOLDER + Util.generateUniqueFileName()+ext );
            Files.write(path, bytes);
            customer.setProfileImg(path.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
		customerServices.addCustomer(customer);
		session.setAttribute("customer", customer);
		System.out.println(customer);
		ModelAndView modelAndVew = new ModelAndView("customerInfo");
		return modelAndVew;

	}
	
	@RequestMapping("dealDetail")
	public ModelAndView showDealPage() {
		ModelAndView modelAndView= new ModelAndView("dealDescription");
		return modelAndView;
	}

	@RequestMapping("homePage")
	public ModelAndView showHomePage() {
		ModelAndView modelAndView= new ModelAndView("homePage");
		return modelAndView;
	}
	
	@RequestMapping("comment")
	public ModelAndView showCommentPage() {
		ModelAndView modelAndView= new ModelAndView("commentForm");
		return modelAndView;
	}

	@RequestMapping("rateTransporter")
	public ModelAndView showRatingPage() {
		ModelAndView modelAndView= new ModelAndView("ratingForm");
		return modelAndView;
	}
}
