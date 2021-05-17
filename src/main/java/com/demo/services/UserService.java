package com.demo.services;

import java.util.Optional;

import com.demo.entities.User;

public interface UserService {
	public Optional<User> getUserById(int id);
}
