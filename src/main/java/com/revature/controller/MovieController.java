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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Movie;
import com.revature.model.User;
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
	public Movie getMovie(@PathVariable String id) {
		return movieService.findById(id);
	}
	
    @GetMapping("/search")
	public ResponseEntity<Set<Movie>> findByTitleContaining(@RequestParam(value="q") String title) {
		return ResponseEntity.ok(movieService.findByTitleContaining(title));
	}
    
    @GetMapping("/search/genre")
	public ResponseEntity<Set<Movie>> findByGenreContaining(@RequestParam(value="q") String genre) {
		return ResponseEntity.ok(movieService.findByGenreContaining(genre));
	}
	
	@PostMapping("/add")
	public void insert(@Valid @RequestBody Movie m) {
		movieService.insert(m);
	}
}
