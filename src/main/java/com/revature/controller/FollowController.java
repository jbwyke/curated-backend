package com.revature.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Follow;
import com.revature.service.FollowService;

@RestController // RestController automatically puts ResponseBody on every public method (that is mapped) within this class
@RequestMapping("/follows") // we can access the methods of this controller at http://localhost:5000/app/users
@CrossOrigin(origins = "http://localhost:5500")
public class FollowController {
	
	@Autowired
	private FollowService followService;
	
	@GetMapping
	public ResponseEntity<Set<Follow>> findAll() {
		return ResponseEntity.ok(followService.findAll());
	}
	
	@GetMapping("/{follower}")
	public Set<Follow> getByFollower(@PathVariable int follower) {
		return followService.findByFollower(follower);
	}
	
	@GetMapping("/{following}")
	public Set<Follow> getByFollowing(@PathVariable int following) {
		return followService.findByFollowing(following);
	}
	
	@GetMapping("/{follower}/{following}")
	public Follow getByFollowerAndFollowing(@PathVariable int follower, @PathVariable int following) {
		return followService.findById(follower, following);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Follow> insert(@Valid @RequestBody Follow follow) {
		return ResponseEntity.ok(followService.addFollow(follow));
	}
}
