package com.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.product.entity.Product;
import com.product.repositary.ProductRepositary;

@Repository
public class ProductDao {
	@Autowired
	ProductRepositary pr;
	
	public String addProduct(List<Product> p) {
		pr.saveAll(p);
		return "Product Added Successfully";
	}
	public List<Product> getAll(){
		return pr.findAll();
	}
	
}
