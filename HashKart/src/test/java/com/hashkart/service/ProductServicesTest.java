package com.hashkart.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.hashkart.dao.CategoryRepository;
import com.hashkart.dao.ProductRepository;
import com.hashkart.entity.Category;
import com.hashkart.entity.Product;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class ProductServicesTest {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Test
	void testListAllProducts() {
		List<Product> findAll = productRepository.findAll();
		assertTrue(findAll.size() > 0);
	}

	@Test
	void testListProductByCategoryId() {
		Integer categoryId = 2;
		List<Product> findAllByCategoryId = productRepository.findAllByCategoryId(categoryId);
		assertThat(!findAllByCategoryId.isEmpty());
	}

	@Test
	void testFindById() {
		Integer productId = 1;
		Product findById = productRepository.findById(productId).get();
		assertEquals(productId, findById.getProductId());
	}

	@Test
	void testFindProductsByCategoryInAscendingOrder() {
		System.out.println(categoryRepository != null);
		Integer categoryId = 1;
		Category findById = categoryRepository.findById(categoryId).get();
		System.out.println(findById.getName());
		List<Product> findByCategoryOrderByPriceAsc = productRepository.findByCategoryOrderByPriceAsc(findById);
		System.out.println(findByCategoryOrderByPriceAsc.get(0).getDescription());
		assertNotNull(findByCategoryOrderByPriceAsc);
	}

}
