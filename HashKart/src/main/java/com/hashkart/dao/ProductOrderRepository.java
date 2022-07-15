package com.hashkart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hashkart.entity.ProductOrder;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {

}
