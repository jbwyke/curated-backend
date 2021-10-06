package com.revature.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Movie;
import com.revature.service.MovieService;

@RestController // RestController automatically puts ResponseBody on every public method (that is mapped) within this class
@RequestMapping("/movies") // we can access the methods of this controller at http://localhost:5000/app/users
@CrossOrigin(origins = "http://localhost:5500") // use origins = "*" to expose the controller to all ports
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	// find all
	@GetMapping
	public ResponseEntity<Set<Movie>> findAll() {
		return ResponseEntity.ok(movieService.findAll());
	}
	
	@GetMapping("/{id}")
	public Movie getMovie(@PathVariable int id) {
		return movieService.findById(id);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Movie> insert(@Valid @RequestBody Movie m) {
		return ResponseEntity.ok(movieService.insert(m));
	}
}
