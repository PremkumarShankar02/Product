package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.product.dao.ProductDao;
import com.product.entity.Product;

@Service
public class ProductService {
	@Autowired
	ProductDao pd;
	
	public String addProduct(List<Product> p) {
		return pd.addProduct(p);
	}
	public List<Product> getAll(){
		return pd.getAll();
	}
	

}
