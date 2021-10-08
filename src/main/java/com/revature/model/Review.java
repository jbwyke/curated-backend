package com.revature.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

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
	@GeneratedValue
	private int reviewId;
	
	@ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = false)
	private int userId;

	@ManyToOne(targetEntity = Movie.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "movie_id", nullable = false)
	private int movieId;
	
	@Range(min = 1, max = 5)
	private int rating;
	
	private boolean recommended;
	
	@Length(min = 0, max = 1500)
	private String review;
}
