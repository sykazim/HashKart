package com.hashkart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hashkart.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
