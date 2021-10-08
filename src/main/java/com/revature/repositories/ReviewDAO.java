package com.revature.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Review;

public interface ReviewDAO extends JpaRepository<Review, Integer>{
	
	public Optional<Review> findByReviewId(int id);

	public Optional<Review> findByUserId(int id);
	
}
