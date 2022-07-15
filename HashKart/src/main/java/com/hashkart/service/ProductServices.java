package com.hashkart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hashkart.dao.ProductRepository;
import com.hashkart.entity.Category;
import com.hashkart.entity.Product;

@Service
public class ProductServices {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> listAllProducts(){
		return productRepository.findAll();
	}
	
	public List<Product> listProductByCategoryId(Integer categoryId){
		return productRepository.findAllByCategoryId(categoryId);
	}

	public Optional<Product> findById(Integer productId) {
		// TODO Auto-generated method stub
		return productRepository.findById(productId);
	}
	
	public List<Product> findProductsByCategoryInAscendingOrder(Category category){
		return productRepository.findByCategoryOrderByPriceAsc(category);
	}

}
