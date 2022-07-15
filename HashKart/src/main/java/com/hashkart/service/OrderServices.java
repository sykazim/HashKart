package com.hashkart.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hashkart.cart.ShoppingCart;
import com.hashkart.dao.CustomerRepository;
import com.hashkart.dao.ProductOrderRepository;
import com.hashkart.entity.Customer;
import com.hashkart.entity.ProductOrder;

@Service
public class OrderServices {
	
	@Autowired
	private ProductOrderRepository productOrderRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	public void placeOrder(HttpServletRequest request, int customerId) {
		String recipientName = request.getParameter("recipientName");
		String recipientPhone = request.getParameter("recipientPhone");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String zipcode = request.getParameter("zipcode");
		String country = request.getParameter("country");
		String paymentMethod = request.getParameter("paymentMethod");
		ProductOrder order = new ProductOrder();
		order.setRecipientName(recipientName);
		order.setRecipientPhone(recipientPhone);
		String shippingAddress = address +", " + city +", "+zipcode+", "+country;
		order.setShippingAddress(shippingAddress);
		order.setPaymentMethod(paymentMethod);
		order.setStatus("initiated");
		long millis = System.currentTimeMillis();
		order.setOrderDate(new java.sql.Date(millis));
		ShoppingCart shoppingCart = (ShoppingCart) request.getSession().getAttribute("cart");
		if(shoppingCart != null) {
			Customer customer = (Customer) customerRepository.findById(customerId).get();
			order.setTotal((float) shoppingCart.getTotalAmount());
			order.setCustomer(customer);
			productOrderRepository.save(order);
			shoppingCart.clear();
		}
		
	}
}
