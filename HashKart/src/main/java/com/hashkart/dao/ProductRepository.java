package com.hashkart.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hashkart.entity.Category;
import com.hashkart.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query(value = "SELECT * FROM Product WHERE category_id = ?1", nativeQuery = true)
	List<Product> findAllByCategoryId(Integer catid);
	
	List<Product> findByCategoryOrderByPriceAsc(Category category);

}
