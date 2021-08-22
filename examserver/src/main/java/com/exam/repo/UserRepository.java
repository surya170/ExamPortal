package com.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.entitiy.User;

public interface UserRepository extends JpaRepository<User, Long> {

	// These implementation taken cre y spring an dit given back to you object.
   public User findByusername(String username);
	

}
