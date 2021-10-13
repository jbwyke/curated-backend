package com.revature.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "user") // schema = "springdata"
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@Column(name = "user_id", nullable = false, unique = true, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@JsonView({ JsonViewProfiles.User.class, JsonViewProfiles.Address.class })
	private int id;

	@Length(min = 2) // hibernate specific
	private String firstName;
	@Length(min = 2) // hibernate specific
	private String lastName;

	@Length(min = 5)
	@NotBlank // this comes From java EE from javax.val...
	@Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]*") // using regex to make sure that only alphanumeric characters are allowed,
												// no spaces allowed
	private String username;

	@NotEmpty
	private String password;
	
	@NotEmpty
	private String email;
	
//    @ManyToMany
//	@JoinTable(name = "users_address",
//    joinColumns = @JoinColumn(name= "user_id"),
//    inverseJoinColumns = @JoinColumn(name = "address_id"))
//    @JsonView(JsonViewProfiles.User.class)
//	private Set<Address> addresses;
	
	@JsonManagedReference // prevents infinite loop
	@OneToMany(targetEntity=Review.class, mappedBy="user")
 	private List<Review> reviews;
	
	@JsonManagedReference(value="user") // prevents infinite loop
	@OneToMany(targetEntity=Follow.class, mappedBy="follow")
 	private List<Follow> followers;
	
	@JsonManagedReference(value="user") // prevents infinite loop
	@OneToMany(targetEntity=Follow.class, mappedBy="follow")
 	private List<Follow> following;

//	public User(@Length(min = 1) String firstName, String lastName,
//			@Length(min = 5) @NotBlank @Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]*") String username,
//			@NotEmpty String password) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.username = username;
//		this.password = password;
//	}
}
