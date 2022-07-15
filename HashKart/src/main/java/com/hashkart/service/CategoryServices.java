package com.hashkart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hashkart.dao.CategoryRepository;
import com.hashkart.entity.Category;

@Service
public class CategoryServices {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> listAllCategories(){
		return categoryRepository.findAll();
	}

}
