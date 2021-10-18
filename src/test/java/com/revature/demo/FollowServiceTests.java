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

import com.revature.model.Follow;
import com.revature.model.Movie;
import com.revature.model.Review;
import com.revature.model.User;
import com.revature.repositories.FollowDAO;
import com.revature.service.FollowService;

public class FollowServiceTests {
	private FollowDAO mockdao;
	private FollowService service;

	@Before
	public void setup() {
		mockdao = mock(FollowDAO.class);
		service = new FollowService();
		service.setFollowDAO(mockdao);
	}

	@After
	public void teardown() {
		mockdao = null;
		service = null;
	}
	
	@Test
	public void testFindAll_success() {
		List<Follow> db = new ArrayList<>();


		User u1 = new User(1, "Bob", "Bobson", "Iambob", "secretbob", "bob@bob.bob", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
		User u2 = new User(2, "Doug", "Dougson", "IamDoug", "secretDoug", "Doug@Doug.Doug", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

		Follow f1 = new Follow(1, u1, u2, null);
		Follow f2 = new Follow(2, u2, u1, null);
		
		db.add(f1);
		db.add(f2);
		

		when(mockdao.findAll()).thenReturn(db);
		assertThat(service.findAll(), hasItems(f2, f2));
	}
}
