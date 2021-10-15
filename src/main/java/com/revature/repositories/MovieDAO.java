package com.revature.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Movie;
import com.revature.model.User;

public interface MovieDAO extends JpaRepository<Movie, Integer>{

	public Optional<Movie> findByTitle(String title);

	public List<Movie> findByTitleContainingIgnoreCase(String title);
	
	public List<Movie> findByGenreContainingIgnoreCase(String genre);

	public Optional<Movie> findById(String id);
}
