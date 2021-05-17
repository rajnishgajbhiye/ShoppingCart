package com.demo.pojo;

import java.util.List;

public class CartPojo {
	private int totalAmount;
	private List<ProductPojo> products;
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public List<ProductPojo> getProducts() {
		return products;
	}
	public void setProducts(List<ProductPojo> products) {
		this.products = products;
	}
	
	
}
