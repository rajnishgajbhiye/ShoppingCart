package com.demo.pojo;

import java.util.List;
import com.demo.entities.Offer;

public class ProductPojo {
	private long productId;

	private int price;

	private String productName;
	
	private int offerApplied;
	
	private int quantity;
	
	private List<Offer> offer;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getOfferApplied() {
		return offerApplied;
	}

	public void setOfferApplied(int offerApplied) {
		this.offerApplied = offerApplied;
	}

	public List<Offer> getOffer() {
		return offer;
	}

	public void setOffer(List<Offer> offer) {
		this.offer = offer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
