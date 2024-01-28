package com.datajpa.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datajpa.spring.dao.ProductDAO;
import com.datajpa.spring.entity.Product;
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public List<Product> findAllProducts() {
		List<Product> allProducts = productDAO.findAll();
		return allProducts;
	}

	@Override
	public Product saveProduct(Product product) {
		productDAO.save(product);
		return product;
		
	}

	@Override
	public Product findProductByID(int id) {
		Product product =null;
		Optional<Product> optionalProduct =productDAO.findById(id);
		if(optionalProduct.isPresent()) {
			product= optionalProduct.get();		
		}
		return product;
	}

	@Override
	public Product deleteById(int id) {
		Product product = null;
		Optional<Product> byId = productDAO.findById(id);
		if(byId.isPresent()) {
			productDAO.deleteById(id);
			
		}
		return product;
	}
	
	

}
