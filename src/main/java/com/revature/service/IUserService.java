package com.revature.service;

import java.util.Optional;

import com.revature.model.User;

// not in use atm
public interface IUserService {

	Optional<User> findById(int id);
}
