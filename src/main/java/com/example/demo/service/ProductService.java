package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;

public interface ProductService {
	public List<Product> findAll();
	
	public List<Product> findByNameAndPrice(String productName, Integer price);
}
