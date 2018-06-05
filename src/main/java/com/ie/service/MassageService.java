package com.ie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ie.entities.User;
import com.ie.repository.UserRepository;

@Service
public class MassageService {
	
	
	@Autowired
	private UserRepository userRepository;

	
	public void update(String password, User user){
		user.setPassword(password);
		userRepository.save(user);
	}
}
