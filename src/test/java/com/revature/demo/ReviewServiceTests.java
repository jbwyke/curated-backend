package com.revature.demo;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.revature.model.Movie;
import com.revature.model.Review;
import com.revature.model.User;
import com.revature.repositories.ReviewDAO;
import com.revature.service.ReviewService;

public class ReviewServiceTests {
	private ReviewDAO mockdao;
	private ReviewService service;

	@Before
	public void setup() {
		mockdao = mock(ReviewDAO.class);
		service = new ReviewService();
		service.setReviewDAO(mockdao);
	}

	@After
	public void teardown() {
		mockdao = null;
		service = null;
	}
	
	@Test
	public void testFindAll_success() {
		List<Review> db = new ArrayList<>();

		List<Review> reviews = new ArrayList<>();

		Movie m1 = new Movie("tt0000000", "movie1", 2017, null, null, null, null, null, null, null, null, null, reviews);
		Movie m2 = new Movie("tt0000001", "movie2", 2020, null, null, null, null, null, null, null, null, null, reviews);
		User u1 = new User(1, "username", null, null, null, null, reviews, null, null);
		

		Review r1 = new Review(1, 3, true, "Good movie", m1, u1);
		Review r2 = new Review(2, 1, false, "Bad movie", m2, u1);
		

		db.add(r1);
		db.add(r2);
		

		when(mockdao.findAll()).thenReturn(db);
		assertThat(service.findAll(), hasItems(r1, r2));
	}
}
