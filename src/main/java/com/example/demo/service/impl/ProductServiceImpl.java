package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDao;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductSevice;

@Service
public class ProductServiceImpl implements ProductSevice{
	
	@Autowired
    private ProductDao productDao;

    @Override
    public Product findById(Integer productId) {
        return productDao.findById(productId);
    }
}
