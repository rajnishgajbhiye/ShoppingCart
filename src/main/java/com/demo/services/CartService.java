package com.demo.services;

import java.util.List;
import java.util.Optional;

import com.demo.entities.Cart;
import com.demo.entities.User;
import com.demo.pojo.PostCartPojo;

public interface CartService {
	public Optional<Cart> getId(int id);
	public void setCart(Cart cart);
	public Optional<Cart> getCartByuserId(User id);
	public List<Cart> getAllCartByUserId(User id);
	public Object getCartValue(int userId);
	public void postCart(int userId, PostCartPojo cart);
}
