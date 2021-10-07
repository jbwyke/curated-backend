package com.revature.service;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.exceptions.GenreNotFoundException;
import com.revature.model.Genre;
import com.revature.repositories.GenreDAO;

@Service
public class GenreService {

	@Autowired
	private GenreDAO genreDAO;
	
	public Set<Genre> findAll() {
		return genreDAO.findAll()
				.stream()
				.collect(Collectors.toSet());
	}
	
	public Genre findById(int id) {
		
		return genreDAO.findById(id)
				.orElseThrow(() -> new GenreNotFoundException("No movie found with id " + id));
	}
	
	public Genre insert(Genre m) {
		return genreDAO.save(m);
	}
	
	public Genre getById(int id) {
		return genreDAO.getById(id);
	}
}

