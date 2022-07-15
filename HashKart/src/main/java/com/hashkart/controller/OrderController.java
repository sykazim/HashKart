package com.hashkart.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hashkart.service.OrderServices;

@RestController
public class OrderController {

	@Autowired
	private OrderServices orderServices;
	
	@GetMapping("/placeOrder/{customerId}")
	public void placeOrder(HttpServletRequest request,@PathVariable(name="customerId")String customerId) {
		
		orderServices.placeOrder(request,Integer.parseInt(customerId));
	}
}
