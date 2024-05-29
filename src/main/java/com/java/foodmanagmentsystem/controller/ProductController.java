package com.java.foodmanagmentsystem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java.foodmanagmentsystem.dao.HotelDao;
import com.java.foodmanagmentsystem.dao.ProductDao;
import com.java.foodmanagmentsystem.entity.Admin;
import com.java.foodmanagmentsystem.entity.Hotel;
import com.java.foodmanagmentsystem.entity.Product;

@Controller
public class ProductController {
	@Autowired
	ProductDao productDao;
	
	@Autowired
	HotelDao hotelDao;
	@RequestMapping("/addproduct")
	public ModelAndView addProduct() {
		Product product= new Product();
		ModelAndView mav=new ModelAndView();
		mav.addObject("productobj", product);
		mav.setViewName("ProductForm");
		return mav;
	}
	
	@RequestMapping("/saveproduct")
	//Handler is use to save product entity into database
	public ModelAndView saveProduct(@ModelAttribute("productobj") Product p,HttpSession session) {
		Integer hotel_id=(Integer)session.getAttribute("hotelinfo");
		Hotel hotel=hotelDao.findById(hotel_id);
		List<Product> products=hotel.getProducts();
		
		if(products.size()>0) {
			products.add(p);
			hotel.setProducts(products);
		}else {
			List<Product> productList=new ArrayList<Product>();
			productList.add(p);
			hotel.setProducts(productList);
		}
		
		productDao.saveProduct(p);
		hotelDao.updateHotel(hotel);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("message","added Successfully");
		mav.setViewName("HotelOptions");
		return mav;	
		
	}
	@RequestMapping("/viewproduct")
	//This Handle is use to fetch all the products of particular hotel and submit to jsp.
	public ModelAndView viewProducts(HttpSession session) {
		Integer hotelId=(Integer) session.getAttribute("hotelinfo");
		Hotel hotel=hotelDao.findById(hotelId);
		if (hotelId == null) {
            return new ModelAndView("redirect://HotelLogin.jsp");
        }

        List<Product> products = hotel.getProducts();
        ModelAndView mav = new ModelAndView();
        mav.addObject("products", products);
        mav.setViewName("ViewProducts");
        return mav;
	}
	@RequestMapping("/updateproduct")
	public ModelAndView updateProduct(@RequestParam("id")int id) {
		Product product=productDao.findById(id);
		ModelAndView mav=new ModelAndView();
		mav.addObject("existingProductInfo",product);
		mav.setViewName("updateproductform");
		return mav;
		
	}
	@RequestMapping("/updateproductinfo")
	public ModelAndView updateProductInformation(@ModelAttribute("existingProductInfo") Product p) {
		productDao.updateProduct(p);
		ModelAndView mav=new ModelAndView();
		mav.addObject("message", "product updated Successfully");
		mav.setViewName("redirect://viewproduct");
		return mav;
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteProduct(@RequestParam("id")int id,HttpSession session) {
		Integer hotel_id=(Integer)session.getAttribute("hotelinfo");
		Hotel hotel=hotelDao.findById(hotel_id);
		List<Product> products=hotel.getProducts();
		List<Product> productList=products.stream().filter(product ->product.getId()!=id).collect(Collectors.toList());
		hotel.setProducts(productList);
		
		hotelDao.updateHotel(hotel);
		productDao.deleteById(id);
		ModelAndView mav=new ModelAndView();
		mav.addObject("message", "product deleted Successfully");
		mav.setViewName("redirect://viewproduct");
		return mav;
	}
	@RequestMapping("/hotellogout")
	// handler is used to delete the admin data in HttpSession
	public ModelAndView HotelLogout(HttpSession session) {
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Logged out successfully");
		mav.setViewName("HotelHomepage");
		return mav;
	}
	
	@RequestMapping("/fetchproductsbyhotel")
	public ModelAndView  fetchProductByHotelName(ServletRequest request) {
		String hotelName=request.getParameter("hotel");
		List<Product> products=productDao.fetchItemByHotel(hotelName);
		ModelAndView mav=new ModelAndView();
		mav.addObject("productsList", products);
		mav.setViewName("displayproducttocustomer");
		return mav;
		
	}
	@RequestMapping("/fetchallproducts")
	public ModelAndView fetchAllProducts() {
		List<Product> products=productDao.findAllProduct();
		ModelAndView mav=new ModelAndView();
		mav.addObject("productsList",products);
		mav.setViewName("displayproducttocustomer");
		return mav;
	}
	@RequestMapping("/fetchproductsbetweenpricerange")
	public ModelAndView fetchAllProductsByRange(ServletRequest request) {
		String minCost=request.getParameter("minprice");
		String maxCost=request.getParameter("maxprice");
		
		List<Product> products=productDao.fetchProductsBetweenPriceRange(Double.parseDouble(minCost), Double.parseDouble(maxCost));
		ModelAndView mav=new ModelAndView();
		mav.addObject("productsList",products);
		mav.setViewName("displayproducttocustomer");
		return mav;
	}
	
	@RequestMapping("/fetchproductbyhotelname")
	public ModelAndView fetchHotelName() {
		List<String> list=hotelDao.findAllHotelName();
		ModelAndView mav=new ModelAndView();
		mav.addObject("allhotellist",list);
		mav.setViewName("/fetchitemsbyhotel");
		return mav;
	}
	
}
