package com.hashkart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hashkart.entity.Category;
import com.hashkart.service.CategoryServices;

@RestController
//@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryServices categoryServices;

	@GetMapping("/category")
	public List<Category> listAll(){
		return categoryServices.listAllCategories();
	}
}
