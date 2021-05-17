package com.demo.entities;

public class Pojo {

	private Cart cart;
	
	private Offer offer;

	public Pojo(Cart cart, Offer offer) {
		super();
		this.cart = cart;
		this.offer = offer;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}
}
