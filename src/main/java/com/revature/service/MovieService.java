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
	
	public Movie findById(String id) {
		
		return movieDAO.findById(id)
				.orElseThrow(() -> new MovieNotFoundException("No movie found with id " + id));
	}
	
	public Set<Movie> findByTitleContaining(String title) {
		return movieDAO.findByTitleContainingIgnoreCase(title)
				.stream()
				.collect(Collectors.toSet());
	}
	
	public Set<Movie> findByGenreContaining(String title) {
		return movieDAO.findByGenreContainingIgnoreCase(title)
				.stream()
				.collect(Collectors.toSet());
	}
	
	public Movie insert(Movie m) {
		return movieDAO.save(m);
	}
	
	public Movie getById(int id) {
		return movieDAO.getById(id);
	}
	
	public Set<Movie> getRandom() {
		return movieDAO.getRandom();
	}
}
