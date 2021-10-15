package com.revature.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table; 
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	
	private String genre;
	private String metacritic;
	private String runtime;
	private String actors;
	
//    @ManyToMany(mappedBy = "movies")
//    private Set<Genre> genres = new HashSet<>();

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="movie")
	@JsonIgnoreProperties(value="movie", allowSetters=true)
 	private List<Review> reviews;


}
