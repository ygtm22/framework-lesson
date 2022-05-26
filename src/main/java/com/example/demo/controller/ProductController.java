package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Product;
import com.example.demo.form.ProductForm;
import com.example.demo.service.ProductSevice;

@Controller
public class ProductController {
	@Autowired
    ProductSevice productService;

    @RequestMapping({ "/", "/top" })
    public String index(@ModelAttribute("top") ProductForm form, Model model) {
        return "top";
    }

    @RequestMapping(value = "/searchResult", method = RequestMethod.POST)
    public String result(@ModelAttribute("top") ProductForm form, Model model) {
        Product product = productService.findById(form.getProductId());
        model.addAttribute("product", product);
        return "searchResult";
    }
}
