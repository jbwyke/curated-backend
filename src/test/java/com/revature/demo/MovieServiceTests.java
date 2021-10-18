package com.revature.demo;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.revature.model.Follow;
import com.revature.model.Movie;
import com.revature.model.Review;
import com.revature.model.User;
import com.revature.repositories.MovieDAO;
import com.revature.service.MovieService;

public class MovieServiceTests {
	private MovieDAO mockdao;
	private MovieService service;
	
	@Autowired
	PasswordEncoder pwdE;

	@Before
	public void setup() {
		mockdao = mock(MovieDAO.class);
		service = new MovieService();
		service.setMovieDAO(mockdao);
	}

	@After
	public void teardown() {
		mockdao = null;
		service = null;
	}
	
	@Test
	public void testFindAll_success() {
		List<Movie> db = new ArrayList<>();
		List<Review> reviews = new ArrayList<>();
		
		Movie m1 = new Movie("tt0000000", "movie1", 2017, null, null, null, null, null, null, null, null, null, reviews);
		Movie m2 = new Movie("tt0000001", "movie2", 2017, null, null, null, null, null, null, null, null, null, reviews);
		db.add(m1);
		db.add(m2);
		

		when(mockdao.findAll()).thenReturn(db);
		assertThat(service.findAll(), hasItems(m1, m2));
	}
	
	@Test
	public void testGetById_success() {
		List<Follow> followers = new ArrayList<>();
		List<Follow> following = new ArrayList<>();
		///////////////////////////		
		
		List<Movie> db = new ArrayList<>();
		List<Review> reviews = new ArrayList<>();
		

		Movie m1 = new Movie("tt0000000", "movie1", 2017, null, null, null, null, null, null, null, null, null, reviews);
		Movie m2 = new Movie("tt0000001", "movie2", 2017, null, null, null, null, null, null, null, null, null, reviews);
		db.add(m1);
		db.add(m2);

		
//		when(mockdao.findById("tt0000000")).thenReturn(m1);
//		
//		assertEquals(m1, service.findById(m1));
		
	}
}
