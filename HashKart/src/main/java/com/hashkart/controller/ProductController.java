package com.hashkart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hashkart.entity.Product;
import com.hashkart.service.CategoryServices;
import com.hashkart.service.ProductServices;

@RestController
public class ProductController {
	
	@Autowired
	private ProductServices productServices;
	
	@Autowired
	private CategoryServices categoryServices;
	
	@GetMapping("/product")
	public List<Product> listAll(){
		return productServices.listAllProducts();
	}
	
	@GetMapping("/product/category/{id}")
	public List<Product> listByCategory(@PathVariable(name = "id") String categoryId,HttpSession session){
		System.out.println(session.getId());
		return productServices.listProductByCategoryId(Integer.parseInt(categoryId));
		//return null;
	}

}
