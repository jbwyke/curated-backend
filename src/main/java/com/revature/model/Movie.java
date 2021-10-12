package com.revature.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table; 
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "movie") // schema = "springdata"
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

	@Id
	@Column(name = "id", nullable = false, unique = true, updatable = false)
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@JsonView({ JsonViewProfiles.User.class, JsonViewProfiles.Address.class })
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
	
	@JsonManagedReference(value="movie") // prevents infinite loop
	@OneToMany(targetEntity=Review.class, mappedBy="movie")
 	private List<Review> reviews;

//	public Movie(@Length(min = 2) @NotEmpty String title, int year, String rated, String released, String director,
//			String plot, String poster) {
//		super();
//		this.title = title;
//		this.year = year;
//		this.rated = rated;
//		this.released = released;
//		this.director = director;
//		this.plot = plot;
//		this.poster = poster;
//	}
}
