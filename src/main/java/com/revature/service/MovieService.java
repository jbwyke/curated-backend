package com.revature.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.exceptions.MovieNotFoundException;
import com.revature.model.Movie;
import com.revature.repositories.MovieDAO;

@Service
public class MovieService {

	@Autowired
	private MovieDAO movieDAO;
	
	public Set<Movie> findAll() {
		return movieDAO.findAll()
				.stream()
				.collect(Collectors.toSet());
	}
	
	public Movie findById(int id) {
		
		return movieDAO.findById(id)
				.orElseThrow(() -> new MovieNotFoundException("No movie found with id " + id));
	}
	
	public Movie insert(Movie m) {
		return movieDAO.save(m);
	}
	
	public Movie getById(int id) {
		return movieDAO.getById(id);
	}
}
