package com.datajpa.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datajpa.spring.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer>{

}
