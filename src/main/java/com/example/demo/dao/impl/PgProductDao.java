package com.example.demo.dao.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.ProductDao;
import com.example.demo.entity.Product;

@Repository
public class PgProductDao implements ProductDao {
	private static final String SQL_SELECT_ALL = "SELECT * FROM products ORDER BY product_id";
	private static final String SQL_SELECT = "SELECT * FROM products WHERE product_name= :productName OR price= :price ORDER BY product_id";
	
	 @Autowired
	 private NamedParameterJdbcTemplate jdbcTemplate;
	 
	 public List<Product> findAll() {
		 	String sql = SQL_SELECT_ALL;
		 	MapSqlParameterSource param = new MapSqlParameterSource();
			return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Product>(Product.class));
	}
	 
	 public List<Product> findByNameAndPrice(String productName, Integer price) {
	        String sql = SQL_SELECT;

	        MapSqlParameterSource param = new MapSqlParameterSource();
	        param.addValue("productName", productName);
	        param.addValue("price", price);

	        List<Product> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Product>(Product.class));
	        
	        return resultList.isEmpty() ? null : (List<Product>) resultList;
	    }
	
	
}
