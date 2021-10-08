package com.revature.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "review")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true, updatable = false)
	private int reviewId;
	
//	@ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "user_id", nullable = false)
//	private int userId;
//
//	@ManyToOne(targetEntity = Movie.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "movie_id", nullable = false)
//	private String movieId;
	

	@Range(min = 1, max = 5)
	private int rating;
	
	private boolean recommended;
	
	@Length(min = 0, max = 1500)
	private String review;
	
	@JsonBackReference // prevents infinite loop
	@ManyToOne(targetEntity = Movie.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "movie_id", nullable = false)
	private Movie movie;
	 
	@JsonBackReference
	@ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;


//	public Review(int userId, String movieId, @Range(min = 1, max = 5) int rating, boolean recommended,
//			@Length(min = 0, max = 1500) String review) {
//		super();
//		this.userId = userId;
//		this.movieId = movieId;
//		this.rating = rating;
//		this.recommended = recommended;
//		this.review = review;
//	}
	
	
}
