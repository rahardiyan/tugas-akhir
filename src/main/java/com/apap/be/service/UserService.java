package com.apap.be.service;

import java.util.List;
import java.util.Optional;

import com.apap.be.model.UserModel;

public interface UserService {

	Optional<UserModel> getUserByUsername(String username);
	
	void addUser(UserModel user);
	
	List<UserModel> getAllUser();

}
