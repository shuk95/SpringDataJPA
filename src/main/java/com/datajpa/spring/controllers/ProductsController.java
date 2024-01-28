package com.datajpa.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.datajpa.spring.entity.Product;
import com.datajpa.spring.service.ProductService;

@RestController
public class ProductsController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	ResponseEntity<List<Product>> getAllProducts(){
		List<Product> allProducts = productService.findAllProducts();		
		return ResponseEntity.status(HttpStatus.OK).body(allProducts);	
	}
	@GetMapping("/products/{id}")
	ResponseEntity<Product> getProductById(@PathVariable("id") int id1) {
		Product product = productService.findProductByID(id1);
			return ResponseEntity.status(HttpStatus.OK).body(product);	
	}
	@PostMapping("/product")
	ResponseEntity<Product> saveProductEntity(@RequestBody Product product){
		Product newproduct = productService.saveProduct(product);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}

	@PutMapping("/product/{id}")
	ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("id") int id1){
	 Product updateProduct = productService.findProductByID(id1);
		updateProduct.setProductCost(product.getProductCost());
		updateProduct.setProductDescription(product.getProductDescription());
		updateProduct.setProductName(product.getProductName());
		productService.saveProduct(updateProduct);
		return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
		
		
	}
	
	@DeleteMapping("/delete/{id}")
	ResponseEntity<Product> deleteProductById(@PathVariable("id") int id1){
		Product deletedProduct = productService.deleteById(id1);
		return ResponseEntity.status(HttpStatus.OK).body(deletedProduct);		
	}
	
	
	
	
	
	
}
