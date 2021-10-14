package com.revature.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

	@Range(min = 1, max = 5)
	private int rating;
	
	private boolean recommended;
	
	@Length(min = 0, max = 1500)
	private String review;
	
	@JoinColumn(nullable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties(value="reviews", allowSetters=true)
	private Movie movie;
	

	@JoinColumn(nullable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties(value="reviews", allowSetters=true)
	private User user;
 
}
