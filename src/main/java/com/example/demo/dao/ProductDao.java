package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Product;

public interface ProductDao {
	public Product findById(Integer productId);
}
