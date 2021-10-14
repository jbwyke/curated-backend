package com.revature.service;


import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.revature.exceptions.UserNotFoundException;
//import com.revature.model.Address;
import com.revature.model.User;
//import com.revature.repositories.AddressDAO;
import com.revature.repositories.UserDAO;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserDAO userDAO;
	
	//class from spring security to encrypt passwords
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public Set<User> findAll() {
		return userDAO.findAll()
				.stream()
				.collect(Collectors.toSet());
	}
	
	public User findByUsername(String username) {
		return userDAO.findByUsername(username)
				.orElseThrow(() -> new UserNotFoundException("No user found with username " + username));
	}
	
	public Set<User> findByUsernameContaining(String username) {
		return userDAO.findByUsernameContaining(username)
				.stream()
				.collect(Collectors.toSet());
	}

	
	public User findById(int id) {
		
		return userDAO.findById(id)
				.orElseThrow(() -> new UserNotFoundException("No user found with id " + id)); // let's create a custom user not found exception 
	}
	
	public User insert(User u) {
		//encrypting the submitted password and sending the encrypted password to the db
		String encodedPassword = this.passwordEncoder.encode(u.getPassword());
		u.setPassword(encodedPassword);
		//		if (u.getAddresses() !=null) {
//			u.getAddresses().forEach(a -> addressDAO.save(a));
//		}
		
		return userDAO.save(u);
	}


	public User getById(int id) {
		return userDAO.getById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u = this.findByUsername(username);
		if(u == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(),
				new ArrayList<>());
	}
	
	/*
	 * the following methods are here for testing purposes
	 */
	public void setUserDAO(UserDAO udao) {
		this.userDAO = udao;
	}
	
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

}
