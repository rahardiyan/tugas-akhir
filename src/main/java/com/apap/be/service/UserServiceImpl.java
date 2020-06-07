package com.apap.be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.be.model.UserModel;
import com.apap.be.repository.UserDb;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDb userDb;
	
	@Override
	public Optional<UserModel> getUserByUsername(String username) {
		return userDb.getUserByUsername(username);
	}

	@Override
	public void addUser(UserModel user) {
		userDb.save(user);
	}

	@Override
	public List<UserModel> getAllUser() {
		return userDb.findAll();
	}
}
