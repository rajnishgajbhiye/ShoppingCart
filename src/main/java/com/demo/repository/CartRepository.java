package com.demo.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.entities.Cart;
import com.demo.entities.User;

public interface CartRepository extends JpaRepository<Cart, Integer>{
	public Optional<Cart> findByUserId(User id);
	public List<Cart> findAllByUserId(User id);
}
