package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.service.ProductService;

@RestController
@RequestMapping(value="/product")
public class ProductController {
	@Autowired
	ProductService ps;
	@PostMapping(value="/add")
	public String addProduct(@RequestBody List<Product> p) {
		return ps.addProduct(p);
	}
	@GetMapping(value="/get")
	public List<Product> getAll(){
		return ps.getAll();
	}

}
