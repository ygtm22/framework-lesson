package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Product;
import com.example.demo.form.ProductForm;
import com.example.demo.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	 @RequestMapping("/top")
	  public String list(@ModelAttribute("top") ProductForm form,Model model) {
	        return "top";
	    }
	 
	 @RequestMapping(value = "/result", params = "param1", method = RequestMethod.POST)
	 public String result(@ModelAttribute("top") ProductForm form, Model model) {
		 String productName = form.getProductName();
		 Integer price  = form.getPrice();
		 
		if (productName.isEmpty() && price == null) {
			productService.findAll();
			model.addAttribute("list", productService.findAll());
		}else {
			List<Product> list = productService.findByNameAndPrice(productName, price);
			if (list == null) {
				model.addAttribute("msg", "対象のデータはありません");
				return "top";
			}else {
				model.addAttribute("list", list);
			}  
		}
		return "result";
	}
	 
	 @RequestMapping(value = "/result", params = "param2", method = RequestMethod.POST)
	 	public String test(@Validated @ModelAttribute("top") ProductForm form, BindingResult bindingResult, Model model) {
	        if (bindingResult.hasErrors()) {
	            return "top";
	        }
	        return "test";
	    }
}
