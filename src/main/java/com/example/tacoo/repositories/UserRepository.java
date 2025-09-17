package com.example.tacoo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tacoo.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername(String username);
	
}
