package com.revature.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Movie;

public interface MovieDAO extends JpaRepository<Movie, Integer>{

	public Optional<Movie> findByTitle(String title);
}
