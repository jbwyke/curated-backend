package com.revature.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "genre") // schema = "springdata"
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Genre {

	@Id
	@Column(name = "movie_id", nullable = false, unique = true, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@JsonView({ JsonViewProfiles.User.class, JsonViewProfiles.Address.class })
	private int id;

	@Length(min = 2) 
	@NotEmpty
	@Column(unique=true)
	private String name;
	
//	@ManyToMany(cascade = {CascadeType.ALL})
//	@JoinTable(
//	        name = "movie_genre", 
//	        joinColumns = { @JoinColumn(name = "movie_id") }, 
//	        inverseJoinColumns = { @JoinColumn(name = "genre_id") }
//	)
//	Set<Movie> movies = new HashSet<>();
}
