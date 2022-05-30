package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDao;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;
	
	 @Override
	 public List<Product> findAll() {
	     return productDao.findAll();
	 }
	 
	 @Override
	 public List<Product> findByNameAndPrice(String productName, Integer price){
	     return productDao.findByNameAndPrice(productName, price);
	 }
}
