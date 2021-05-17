package com.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Cart;
import com.demo.entities.Product;
import com.demo.entities.User;
import com.demo.pojo.CartPojo;
import com.demo.pojo.PostCartPojo;
import com.demo.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	ComputeService computeService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;
	
	public Optional<Cart> getId(int id) {
		return cartRepository.findById(id);
	}
	
	public void setCart(Cart cart) {
		cartRepository.save(cart);
	}

	@Override
	public Optional<Cart> getCartByuserId(User id) {
		return cartRepository.findByUserId(id);
	}
	
	@Override
	public List<Cart> getAllCartByUserId(User id) {
		return cartRepository.findAllByUserId(id);
	}
	
	public Object getCartValue(int userId) {
		try {
			List<Cart> carts = cartService.getAllCartByUserId(userService.getUserById(userId).get()).stream().collect(Collectors.toList());
			return computeService.getCartWithSuggestedOffer(carts);
		} catch(Exception ex) {
			return "Input Invalid";
		}
		
	}
	
	public void postCart(int userId, PostCartPojo cartPojo) {
		User user = userService.getUserById(userId).get();
		Product product = productService.getProductById((int)cartPojo.getProductId()).get();
			
		Cart cart = new Cart();
		cart.setUserId(user);
		cart.setProductId(product);
		cart.setQuantity(cartPojo.getQuantity());
		cartService.setCart(cart);	
	}
}
