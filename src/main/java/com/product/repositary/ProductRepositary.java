package com.product.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entity.Product;

public interface ProductRepositary extends JpaRepository<Product,Integer> {
	

}
