package com.exam.services;

import java.util.Set;

import com.exam.entitiy.User;
import com.exam.entitiy.UserRole;

public interface UserService {
    
	//creating user
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	 //get user by username
	public User getUser(String username);
	//delete user by id
	public void deleteUser(Long userId);
	//update user by id
	//public User updateUser(Long userId);
   
}
