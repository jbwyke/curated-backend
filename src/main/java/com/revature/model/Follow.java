package com.revature.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "follow")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonIdentityInfo(
//		generator=ObjectIdGenerators.PropertyGenerator.class, 
//		property="id")
public class Follow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true, updatable = false)
	private int followId;
	
	@JoinColumn(nullable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties(value={"followers", "reviews", "following"}, allowSetters=true)
	private User follower;
	
	@JoinColumn(nullable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties(value={"following", "reviews", "followers"}, allowSetters=true)
	private User following;

//	@JsonBackReference(value="follow_user")
//	@ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "follower_id", nullable = false)
//	private User follower;
//	
//	@JsonBackReference(value="following_user")
//	@ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "following_id", nullable = false)
//	private User following;
	
	@Temporal(TemporalType.DATE)
	private Date followDate;
}
