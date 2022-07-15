package com.hashkart.cart;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.hashkart.entity.Product;


public class ShoppingCart {
	
	private Map<Product,Integer> cart = new HashMap<Product, Integer>();
	
	
	public void addItem(Product product) {
		if(cart.containsKey(product)) {
			Integer quantity = cart.get(product)+1;
			cart.put(product, quantity);
		}
		else {
			cart.put(product, 1);
		}
		
	}
	
	public void removeItem(Product product) {
		cart.remove(product);
	}
	
	public void updateCart(int productIds[],int quantities[]) {
		for(int i=0;i<productIds.length;i++) {
			Product key = new Product(productIds[i]);
			Integer value = quantities[i];
			cart.put(key, value);
		}
	}
	
	public int getTotalQuantity() {
		int total=0;
		int quantity;
		Iterator<Product> iterator = cart.keySet().iterator();
		while(iterator.hasNext()) {
			Product next = iterator.next();
			quantity = cart.get(next);
			total += quantity;
		}
		return total;
	}
	
	public double getTotalAmount() {
		double total = 0.0f;
		double price = 0.0f;
		int quantity;
		Iterator<Product> iterator = cart.keySet().iterator();
		while(iterator.hasNext()) {
			Product next = iterator.next();
			quantity = cart.get(next);
			price = next.getPrice() * quantity;
			total += price;
		}
		return total;
	}
	
	public void clear() {
		cart.clear();
	}
	
	public int getTotalItems() {
		return cart.size();
	}
	public Map<Product,Integer> getItems(){
		return this.cart;
	}

}
