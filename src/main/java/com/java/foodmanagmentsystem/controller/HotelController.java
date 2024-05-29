package com.java.foodmanagmentsystem.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java.foodmanagmentsystem.dao.HotelDao;
import com.java.foodmanagmentsystem.entity.Hotel;

@Controller
public class HotelController {
	@Autowired
	HotelDao dao;
	
	@RequestMapping("/addHotel")
	// handler used to create Hotel class Object and pass it to HotelForm.jsp
	public ModelAndView addHotel() {
		Hotel hotel=new Hotel();
		ModelAndView mav=new ModelAndView();
		mav.addObject("hotelobj", hotel);
		mav.setViewName("HotelForm");
		return mav;
	}
	
	@RequestMapping("/savehotel")
	// handler used to save Hotel information in database.
	public ModelAndView saveHotel(@ModelAttribute("hotelobj") Hotel hotel) {
		hotel.setStatus("Not Approved");
		dao.saveHotel(hotel);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("message", "Your Account is in review,Plese wait for Review");
		mav.setViewName("HotelLogin");
		return mav;
	}
	
	@RequestMapping("/hotelloginvalidate")
	// handler used to perform hotel login validation and return appropriate response

	public ModelAndView loginValidate(ServletRequest request,HttpSession session) {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		Hotel hotel=dao.login(email, password);
		
		if(hotel!=null) {

			if (hotel.getStatus().equals("Not approved")) {
				ModelAndView mav = new ModelAndView();
				mav.addObject("message", "your account is in review, please wait for sometime");
				mav.setViewName("displaymessage");
				return mav;
			} else if (hotel.getStatus().equals("blocked")) {
				ModelAndView mav = new ModelAndView();
				mav.addObject("message", "your account is blocked");
				mav.setViewName("displaymessage");
				return mav;
			} else {
				//stroing hotel entity object into session
				//storing the loggein into the session
				session.setAttribute("hotelinfo", hotel.getId());
				ModelAndView mav = new ModelAndView();
				mav.addObject("message", "logged in successfully");
				mav.setViewName("HotelOptions");
				return mav;
			}
		}
		else {
			ModelAndView mav=new ModelAndView();
			mav.addObject("message","invalid credentials");
			mav.setViewName("HotelLogin");
			return mav;
		}
		
	}
	@RequestMapping("/fetchunapprovedhotels")
	// handler is used to return unapproved hotels
	public ModelAndView fetchUnapprovedHotela() {
		List<Hotel> hotels=dao.findUnapprovedHotels();
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("unapprovedhotels", hotels);
		mav.setViewName("displayunapprovedhotels");
		return mav;
		
	}
	@RequestMapping("/approvehotel")
	// handler is used to modify the hotel status as approved
	public ModelAndView approveHotel(@RequestParam("id") int id) {
		Hotel h = dao.findById(id);
		h.setStatus("approved");
		dao.updateHotel(h);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect://fetchunapprovedhotels");
		return mav;
	}
	
	@RequestMapping("/viewUnblock")
	// handler is used to return Unblock hotels
	public ModelAndView viewUnblockedHotels() {
		List<Hotel> hotels=dao.findAllUnblockedHotels();
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("unblockhotels", hotels);
		mav.setViewName("viewallunblockhotels");
		return mav;
		
	}
	@RequestMapping("/blockhotel")
	public ModelAndView blockHotel(@RequestParam("id") int id) {
		Hotel h=dao.findById(id);
		h.setStatus("Blocked");
		dao.updateHotel(h);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect://viewUnblock");
		return mav;
	}
	
	@RequestMapping("/viewBlock")
	// handler is used to return Block hotels
	public ModelAndView viewBlockHotels() {
		List<Hotel> hotels=dao.findAllBlockedHotels();

		ModelAndView mav=new ModelAndView();
		mav.addObject("blockhotels",hotels);
		mav.setViewName("viewallblockhotels");
		return mav;
	}
	
	@RequestMapping("/unblockblockhotel")
	public ModelAndView unblockHotel(@RequestParam("id") int id) {
		Hotel h=dao.findById(id);
		h.setStatus("approved");
		dao.updateHotel(h);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect://viewBlock");
		return mav;
	}

	@RequestMapping("/adminlogout")
	// handler is used to delete the admin data in HttpSession
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Logged out successfully");
		mav.setViewName("Adminhome");
		return mav;
	}
	
	

}
