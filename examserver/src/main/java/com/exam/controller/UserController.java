package com.exam.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entitiy.Role;
import com.exam.entitiy.User;
import com.exam.entitiy.UserRole;
import com.exam.helper.UserFoundException;
import com.exam.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
 
	@Autowired
	 private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//creatig user 
	
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception
 	{
		
		 user.setProfile("default.png");
		 //TODO : ENCODE THE PASSWORD with BCryptpassword encoder()
		    user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		 
		Set<UserRole> roles = new HashSet<>();
		 
		Role role = new Role();
		role.setRoleId(46L);
		role.setRoleName("NORMAL");
		 
		UserRole userRole = new UserRole();
		  userRole.setUser(user);
		  userRole.setRole(role);
		
		  roles.add(userRole);
		
       return  this.userService.createUser(user,roles);
	}
	
	//getting the user data from databaase 
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username){
		
		return this.userService.getUser(username);
	}
	
	//delete the user by id
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {
		this.userService.deleteUser(userId);
	}
	
	//updating the user by id
	
//	@PutMapping("/{userId}")
//	public User updateUser(@RequestBody User user , @PathVariable("userId") Long userId) {
//		
//		User user1 = this.userService.updateUser(userId);
//		
//		
//	}
//	
	
	
	

    @ExceptionHandler(UserFoundException.class)
    public ResponseEntity<?> exceptionHandler(UserFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }
	
	
	
	
	
	
}
