package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
