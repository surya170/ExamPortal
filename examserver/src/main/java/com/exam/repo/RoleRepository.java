package com.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.entitiy.Role;
import com.exam.entitiy.User;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
   //public User findByUsername(String username);	
    
}
