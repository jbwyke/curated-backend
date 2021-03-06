package com.revature.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer>{

	/*
	 * This is a Property Expression
	 * Property Expressions infer SQL statements on entities based on the DIRECT
	 * properties of the entity being mangaged.
	 */
	
	// Since we are inheriting all methods from JPARepository, we already have save(), get()...etc...
	public Optional<User> findByUsername(String username);
	// eventually venture into Optional.ofNullable
	
	public List<User> findByUsernameContaining(String username);
	

	@Transactional // This means I want this particualr method to be part of a transaction
	// @Modifying  // I would use this if I intend for some method to manipulate and modify data in a DB
	@Query(value= "FROM User WHERE email LIKE %:substr") // Note that I'm calling the Java properties and object name -> this is JPQL 
	public List<User> findByEmailContains(String substr); // johnsmi -> reutrns johnsmith@gmail.com
	
	@Transactional
	@Modifying
	@Query(value= "UPDATE User u set u.firstName = ?1, u.lastName = ?2, u.username = ?3 WHERE u.id = ?4")
	void setUserInfoById(String firstName, String lastName, String username, Integer userId);
	
}
