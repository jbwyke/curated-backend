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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.LoginForm;
import com.revature.model.User;
import com.revature.service.UserService;




@RestController // RestController automatically puts ResponseBody on every public method (that is mapped) within this class
@RequestMapping("/users") // we can access the methods of this controller at http://localhost:5000/app/users
@CrossOrigin(origins = "http://localhost:5500") // use origins = "*" to expose the controller to all ports
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// find all
	@GetMapping
	public ResponseEntity<Set<User>> findAll() {
		return ResponseEntity.ok(userService.findAll());
	}
	
	
//	 find by username /{username} use @pathvariable as your parameter
	@GetMapping("/")
	public ResponseEntity<User> findByUsername(@RequestParam(value="username") String username) {
		return ResponseEntity.ok(userService.findByUsername(username));
	}
	
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userService.findById(id);
    }
    
    @GetMapping("/search")
	public ResponseEntity<Set<User>> findByUsernameContaining(@RequestParam(value="u") String username) {
		return ResponseEntity.ok(userService.findByUsernameContaining(username));
	}
	
	// insert
	@PostMapping("/add")
	public ResponseEntity<User> insert(@Valid @RequestBody User u) {

		return ResponseEntity.ok(userService.insert(u));
		
	} 
	
	@PostMapping("/login") 
	public ResponseEntity<User> login(@RequestBody LoginForm lf) {
		
		ResponseEntity<User> entity;
		try {
			entity = findByUsername(lf.getUsername());
			User user = entity.getBody();

			if (!user.getPassword().equals(lf.getPassword())) {
				throw new Exception();
			}
			return entity;
		} catch (Exception e) {
			System.out.println("The username or password provided is incorrect");
			return null;
		}
	}
}
