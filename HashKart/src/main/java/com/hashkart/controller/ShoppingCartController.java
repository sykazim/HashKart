package com.hashkart.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hashkart.cart.ShoppingCart;
import com.hashkart.entity.Product;
import com.hashkart.service.ProductServices;

@RestController
public class ShoppingCartController {

	@Autowired
	private ProductServices productServices;
	
	@GetMapping("/addToCart")
	public void addProductToCart(HttpServletRequest request) {
		Integer productId = Integer.parseInt(request.getParameter("productId"));
		Optional<Product> product = productServices.findById(productId);
		Object cartObject = request.getSession().getAttribute("cart");
		ShoppingCart shoppingCart = null;
		if(cartObject != null) {
			shoppingCart = (ShoppingCart) cartObject;
		}
		else {
			shoppingCart = new ShoppingCart();
			request.getSession().setAttribute("cart", shoppingCart);
		}
		
		shoppingCart.addItem(product.get());
	}
	@GetMapping("/viewCart")
	public List<Product> viewCart(HttpServletRequest request){
		Object cartObject = request.getSession().getAttribute("cart");
		ShoppingCart shoppingCart = null;
		if(cartObject != null) {
			List<Product>products = new ArrayList<>();
			shoppingCart = (ShoppingCart) cartObject;
			Map<Product, Integer> totalItems = shoppingCart.getItems();
			Iterator<Product> iterator = totalItems.keySet().iterator();
			while(iterator.hasNext()) {
				Product next = iterator.next();
				products.add(next);
			}
			return products;
		}
		
		return null;
	}
	
	@GetMapping("/checkout")
	public List<List<Object>> checkOut(HttpServletRequest request) {
		Object cartObject = request.getSession().getAttribute("cart");
		ShoppingCart shoppingCart = null;
		List<List<Object>> list = new ArrayList<>();
		List<Object>products = new ArrayList<>();
		if(cartObject != null) {
			//List<Product>products = new ArrayList<>();
			shoppingCart = (ShoppingCart) cartObject;
			Map<Product, Integer> totalItems = shoppingCart.getItems();
			Iterator<Product> iterator = totalItems.keySet().iterator();
			while(iterator.hasNext()) {
				Product next = iterator.next();
				products.add(next.getProductId());
				products.add(next.getDescription());
				products.add(next.getPrice());
				products.add(totalItems.get(next));
				products.add(next.getPrice() * totalItems.get(next));
			}
			list.add(products);
			return list;
		}
		return null;
	}
}