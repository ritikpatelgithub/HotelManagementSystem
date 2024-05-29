package com.java.foodmanagmentsystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java.foodmanagmentsystem.dao.ItemDao;
import com.java.foodmanagmentsystem.dao.ProductDao;
import com.java.foodmanagmentsystem.entity.Item;
import com.java.foodmanagmentsystem.entity.Product;

@Controller
public class ItemController {
	@Autowired
	ItemDao itemDao;
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping("/additem")
	public ModelAndView addItem(@RequestParam("id") int productId) {
		Product products= productDao.findById(productId);
		Item item=new Item();
		item.setName(products.getName());
		item.setType(products.getType());
		item.setCost(products.getCost());
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("itemobj",item);
		mav.setViewName("itemform");
		return mav;
		
	}
	
	@RequestMapping("/saveitemorder")
	public ModelAndView saveItemOrder(@ModelAttribute("itemobj")Item item,HttpSession session) {
		item.setCost(item.getQuantity()*item.getCost());
		
		if(session.getAttribute("itemlist")==null) {
			List<Item> items=new ArrayList<>();
			items.add(item);
			session.setAttribute("itemlist", items);
		}
		else {
			List<Item> items=(List<Item> )session.getAttribute("itemlist");
			items.add(item);
		}
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("message","added Successfully");
		mav.setViewName("redirect://fetchallproducts");
		return mav;
	}

}
