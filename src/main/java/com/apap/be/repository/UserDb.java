package com.apap.be.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.be.model.UserModel;

public interface UserDb extends JpaRepository<UserModel, Long> {
	
	Optional<UserModel> getUserByUsername(String username);
	
}
