package com.hashkart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hashkart.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
