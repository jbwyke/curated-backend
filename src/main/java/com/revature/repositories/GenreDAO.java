package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Genre;
import com.revature.model.Movie;

public interface GenreDAO extends JpaRepository<Genre, Integer>{

}
