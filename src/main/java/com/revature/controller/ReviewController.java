package com.revature.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Review;
import com.revature.service.ReviewService;

@RestController // RestController automatically puts ResponseBody on every public method (that is mapped) within this class
@RequestMapping("/reviews") // we can access the methods of this controller at http://localhost:5000/app/users
@CrossOrigin(origins = "http://localhost:5500") // use origins = "*" to expose the controller to all ports
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@GetMapping
	public ResponseEntity<Set<Review>> findAll() {
		return ResponseEntity.ok(reviewService.findAll());
	}
	
	@GetMapping("/{id}")
	public Review getReview(@PathVariable int id) {
		Review r = reviewService.findById(id);
		System.out.println();
		return r;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Review> insert(@Valid @RequestBody Review review) {
		return ResponseEntity.ok(reviewService.addReview(review));
	}
	
	
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
    	reviewService.delete(id);
    }
	
}
