package com.datajpa.spring.service;

import java.util.List;

import com.datajpa.spring.entity.Product;

public interface ProductService {
	
	List<Product> findAllProducts();
	
	Product saveProduct(Product product);

	Product findProductByID(int id);

	Product deleteById(int id);

}
