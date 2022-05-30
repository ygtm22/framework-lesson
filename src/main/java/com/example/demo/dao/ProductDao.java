package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Product;

public interface ProductDao {
	public List<Product> findAll();
	
	public List<Product> findByNameAndPrice(String productName, Integer price);
}
