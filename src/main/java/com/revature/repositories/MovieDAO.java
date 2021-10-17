package com.revature.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.model.Movie;
import com.revature.model.User;

public interface MovieDAO extends JpaRepository<Movie, Integer>{

	public Optional<Movie> findByTitle(String title);

	public List<Movie> findByTitleContainingIgnoreCase(String title);
	
	public List<Movie> findByGenreContainingIgnoreCase(String genre);
	
	@Query(nativeQuery=true, value="SELECT *  FROM movie ORDER BY random() LIMIT 10")
	public Set<Movie> getRandom();

	public Optional<Movie> findById(String id);
}
