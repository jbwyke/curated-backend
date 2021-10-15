package com.revature.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.exceptions.ReviewNotFoundException;
import com.revature.model.Review;
import com.revature.repositories.ReviewDAO;

@Service
public class ReviewService {

	@Autowired
	private ReviewDAO reviewDAO;

	public Set<Review> findAll() {
		return reviewDAO.findAll().stream().collect(Collectors.toSet());
	}

	// find individual review
	public Review findById(int id) {
		return reviewDAO.findById(id).orElseThrow(() -> new ReviewNotFoundException("No review found with id " + id));
	}
	
	public Review addReview(Review review) {
		return reviewDAO.save(review);
	}
	
	public Review update(Review review) {
		return reviewDAO.save(review);
	}
	
	public void delete(int id) {
		Review r = findById(id);
		r.setUser(null);
		r.setMovie(null);
		r = update(r);
		System.out.println(r.toString());
//		reviewDAO.deleteById(r.getReviewId());
	}

}
