package com.java.foodmanagmentsystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.foodmanagmentsystem.dao.CustomerDao;
import com.java.foodmanagmentsystem.dao.FoodOrderDao;
import com.java.foodmanagmentsystem.entity.Customer;
import com.java.foodmanagmentsystem.entity.FoodOrder;
import com.java.foodmanagmentsystem.entity.Item;

@Controller
public class foodOrderController {
	
	@Autowired
	FoodOrderDao foodOrderDao;
	
	@Autowired
	CustomerDao customeDao;
	
	@RequestMapping("/addfoodorder")
	public ModelAndView addFoodOrder(HttpSession session) {
	//	List<Item> items=(List) session.getAttribute("itemlist");
		
		FoodOrder foodOrder=new FoodOrder();
		//foodOrder.setItems(items);
		//double totalprice=0;
		
		//double totalprice=items.stream().map(i->i.getCost()).mapToDouble(Double::new).sum();
		//foodOrder.setTotalPrice(totalprice);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("foodorderobj", foodOrder);
		mav.setViewName("foodorderform");
		return mav;
		
	}
	@RequestMapping("/savefoodorder")
	public ModelAndView saveFoodOrders(@ModelAttribute("foodorderobj") FoodOrder foodOrder,HttpSession session) {
		Integer customerId=(Integer) session.getAttribute("customerinfo");
		List<Item> items=(List) session.getAttribute("itemlist");
		foodOrder.setItems(items);

		double totalprice=items.stream().map(i->i.getCost()).mapToDouble(Double::new).sum();
		foodOrder.setTotalPrice(totalprice);
		Customer customer=customeDao.findById(customerId);
		
		List<FoodOrder> foodOrders=customer.getOrders();
		if(foodOrders.size()>0) {
			foodOrders.add(foodOrder);
		}
		else {
			List<FoodOrder> foodOrderslist=new ArrayList<>();
			foodOrderslist.add(foodOrder);
			customer.setOrders(foodOrderslist);
		}
		foodOrderDao.saveFoodOrder(foodOrder);
		customeDao.updateCustomer(customer);
		//session.removeAttribute("itemlist");
		ModelAndView mav=new ModelAndView();
		mav.addObject("message","Order Successfully");
		mav.addObject("foodOrderInfo", foodOrder);
		mav.setViewName("displaybilltocustomer");
		return mav;
		
	}
}
