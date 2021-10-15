package com.revature.demo;

import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.revature.exceptions.UserNotFoundException;
import com.revature.model.Follow;
import com.revature.model.Review;
import com.revature.model.User;
import com.revature.repositories.UserDAO;
import com.revature.service.UserService;

public class UserServiceTests {

	private UserDAO mockdao;
	private UserService userv;
	
	@Autowired
	PasswordEncoder pwdE;

	@Before
	public void setup() {
		mockdao = mock(UserDAO.class);
		userv = new UserService();
		userv.setUserDAO(mockdao);
		userv.setPasswordEncoder(pwdE);
	}

	@After
	public void teardown() {
		mockdao = null;
		userv = null;
	}

	@Test
	public void testFindByUsername_success() {
		
		List<User> db = new ArrayList<>();
		List<Review> reviews = new ArrayList<>();
		List<Follow> followers = new ArrayList<>();
		List<Follow> following = new ArrayList<>();
		
		User u1 = new User(1, "Bob", "Bobson", "Iambob", "secretbob", "bob@bob.bob", reviews, followers, following);
		db.add(u1);
		User u2 = new User(2, "Doug", "Dougson", "IamDoug", "secretDoug", "Doug@Doug.Doug", reviews, followers, following);
		db.add(u2);
		
		when(mockdao.findByUsername("Iambob")).thenReturn(Optional.of(u1));
		
		assertEquals(u1, userv.findByUsername("Iambob"));
		
	}
	
	@Test
	public void testFindAll_success() {
		List<User> db = new ArrayList<>();
		List<Review> reviews = new ArrayList<>();
		List<Follow> followers = new ArrayList<>();
		List<Follow> following = new ArrayList<>();
		
		User u1 = new User(1, "Bob", "Bobson", "Iambob", "secretbob", "bob@bob.bob", reviews, followers, following);
		db.add(u1);
		User u2 = new User(2, "Doug", "Dougson", "IamDoug", "secretDoug", "Doug@Doug.Doug", reviews, followers, following);
		db.add(u2);
		
		when(mockdao.findAll()).thenReturn(db);
		
		assertThat(userv.findAll(), hasItems(u1, u2));
	}
	
	@Test
	public void testFindByUsername_throwsUserNotFoundException() {
		
		assertThrows(UserNotFoundException.class, () -> userv.findByUsername("Iambob"));
		
	}
	
	@Test
	public void testFindById_success() {
		
		List<User> db = new ArrayList<>();
		List<Review> reviews = new ArrayList<>();
		List<Follow> followers = new ArrayList<>();
		List<Follow> following = new ArrayList<>();
		
		User u1 = new User(1, "Bob", "Bobson", "Iambob", "secretbob", "bob@bob.bob", reviews, followers, following);
		db.add(u1);
		User u2 = new User(2, "Doug", "Dougson", "IamDoug", "secretDoug", "Doug@Doug.Doug", reviews, followers, following);
		db.add(u2);
		
		when(mockdao.findById(2)).thenReturn(Optional.of(u2));
		
		assertEquals(u2, userv.findById(2));
		
	}
	
	@Test
	public void testFindById_throwsUserNotFoundException() {
		
		assertThrows(UserNotFoundException.class, () -> userv.findById(1));
		
	}
	
	@Test
	public void testFindByUsernameContaining_success() {
		List<User> db = new ArrayList<>();
		List<Review> reviews = new ArrayList<>();
		List<Follow> followers = new ArrayList<>();
		List<Follow> following = new ArrayList<>();
		
		User u1 = new User(1, "Bob", "Bobson", "Iambob", "secretbob", "bob@bob.bob", reviews, followers, following);
		db.add(u1);
		
		when(mockdao.findByUsernameContaining("ob")).thenReturn(db);
		
		assertThat(userv.findByUsernameContaining("ob"), hasItems(u1));
	}
	
	@Test
	public void testFindByUsernameContaining_returnsEmptySet() {
		
		Set<User> db = new HashSet<>();
		
		assertEquals(db, userv.findByUsernameContaining("ob"));
		
	}
	
	@Test
	public void testGetById_success() {
		
		List<User> db = new ArrayList<>();
		List<Review> reviews = new ArrayList<>();
		List<Follow> followers = new ArrayList<>();
		List<Follow> following = new ArrayList<>();
		
		User u1 = new User(1, "Bob", "Bobson", "Iambob", "secretbob", "bob@bob.bob", reviews, followers, following);
		db.add(u1);
		User u2 = new User(2, "Doug", "Dougson", "IamDoug", "secretDoug", "Doug@Doug.Doug", reviews, followers, following);
		db.add(u2);
		
		when(mockdao.getById(2)).thenReturn(u2);
		
		assertEquals(u2, userv.getById(2));
		
	}
	
	@Test
	public void testGetById_returnsNull() {
		
		assertNull(userv.getById(0));
		
	}
	
	@Test
	public void testLoadUserByUsername_success() {
		
		List<User> db = new ArrayList<>();
		List<Review> reviews = new ArrayList<>();
		List<Follow> followers = new ArrayList<>();
		List<Follow> following = new ArrayList<>();
		
		User u1 = new User(1, "Bob", "Bobson", "Iambob", "secretbob", "bob@bob.bob", reviews, followers, following);
		
		when(mockdao.findByUsername("Iambob")).thenReturn(Optional.of(u1));
		
		assertEquals(new org.springframework.security.core.userdetails.User("Iambob", "Bobson", new ArrayList<>()), userv.loadUserByUsername("Iambob"));
		
	}
	
	@Test
	public void testLoadUserByUsername_returnsNull() {
		
//		when(mockdao.findByUsername("Iambob")).thenReturn(null);
		
		assertThrows(UserNotFoundException.class, () -> userv.loadUserByUsername("Iambob"));
		
	}
	
//	//commented out due to inability to instantiate encrypter
//	@Test
//	public void testInsertUser_successWithEncryption() {
//
//		List<User> db = new ArrayList<>();
//		List<Review> reviews = new ArrayList<>();
//		List<Follow> followers = new ArrayList<>();
//		List<Follow> following = new ArrayList<>();
//		
//		User u1 = new User(1, "Bob", "Bobson", "Iambob", "secretbob", "bob@bob.bob", reviews, followers, following);
//		db.add(u1);
//		
//		when(mockdao.findByUsername("Iambob")).thenReturn(Optional.of(u1));
//		
//		//make sure the list returned is only one user (bob)
//		assertEquals(db.size(), 1);
//		
//		//assert that the list of one is bob (except for the password, which should be different)
//		assertThat(userv.insert(u1), allOf(
//				hasProperty("firstName", is("Bob")),
//				hasProperty("lastName", is("Bobson")),
//				hasProperty("username", is("Iambob")),
//				hasProperty("password", not("secretbob")),
//				hasProperty("email", is("bob@bob.bob"))
//				));
//		
//	}
	
}
