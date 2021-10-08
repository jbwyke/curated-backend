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

import com.revature.model.Genre;
import com.revature.service.GenreService;

@RestController // RestController automatically puts ResponseBody on every public method (that is mapped) within this class
@RequestMapping("/genres") // we can access the methods of this controller at http://localhost:5000/app/users
@CrossOrigin(origins = "http://localhost:5500") // use origins = "*" to expose the controller to all ports
public class GenreController {

	@Autowired
	private GenreService genreService;
	
	@GetMapping
	public ResponseEntity<Set<Genre>> findAll() {
		return ResponseEntity.ok(genreService.findAll());
	}
	
	@GetMapping("/{id}")
	public Genre getGenreById(@PathVariable int id) {
		return genreService.findById(id);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Genre> insert(@Valid @RequestBody Genre g) {
		return ResponseEntity.ok(genreService.insert(g));
	}
}
