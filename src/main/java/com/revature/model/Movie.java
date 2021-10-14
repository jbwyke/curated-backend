package com.revature.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table; 
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "movie") // schema = "springdata"
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

	@Id
	@Column(nullable = false, unique = true, updatable = false)
	private String id;

	@Length(min = 2) 
	@NotEmpty
	private String title;
	private int year;
	private String rated;
	private String released;
	private String director;
	private String plot;
	private String poster;
	

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="movie")
	@JsonIgnoreProperties(value="movie", allowSetters=true)
 	private List<Review> reviews;


}
