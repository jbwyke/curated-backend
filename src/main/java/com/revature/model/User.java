package com.revature.model;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "user") // schema = "springdata"
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@Column(nullable = false, unique = true, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Length(min = 2) // hibernate specific
	private String firstName;
	@Length(min = 2) // hibernate specific
	private String lastName;

	@Length(min = 5)
	@NotBlank // this comes From java EE from javax.val...
	@Column(unique=true)
	@Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]*") // using regex to make sure that only alphanumeric characters are allowed,
												// no spaces allowed
	private String username;

	@NotEmpty
	private String password;
	
	@NotEmpty
	@Column(unique=true)
	private String email;
	
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="user")
	@JsonIgnoreProperties(value="user", allowSetters=true)
 	private List<Review> reviews;
	
	// FIX THE TWO  BELOW THIS
	@JsonManagedReference(value="follow_user") // prevents infinite loop
	@OneToMany(targetEntity=Follow.class, mappedBy="following")
 	private List<Follow> followers;
	
	@JsonManagedReference(value="following_user") // prevents infinite loop
	@OneToMany(targetEntity=Follow.class, mappedBy="follower")
 	private List<Follow> following;

	public User(@Length(min = 2) String firstName, @Length(min = 2) String lastName,
			@Length(min = 5) @NotBlank @Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]*") String username,
			@NotEmpty String password, @NotEmpty String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
	}


}
