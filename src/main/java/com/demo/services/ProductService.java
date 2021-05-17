package com.demo.services;

import java.util.Optional;

import com.demo.entities.Product;

public interface ProductService {
	public Optional<Product> getProductById(long id);
}
