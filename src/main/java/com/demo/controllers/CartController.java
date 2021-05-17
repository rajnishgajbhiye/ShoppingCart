package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.pojo.CartPojo;
import com.demo.pojo.PostCartPojo;
import com.demo.services.CartService;
import com.demo.services.ComputeService;
import com.demo.services.UserService;

@RestController
@RequestMapping(value = "cart")
public class CartController {
	@Autowired
	CartService cartService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ComputeService computeService;
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.POST, consumes = "application/json")
	public void postCart(@RequestBody PostCartPojo cart, @PathVariable("userId") int userId) {
		cartService.postCart(userId, cart);
	}
	
	@RequestMapping(value = "user/cart/{userId}", method = RequestMethod.GET)
	public Object getCartValue(@PathVariable("userId") int userId) {
		return cartService.getCartValue(userId);
	}
}
