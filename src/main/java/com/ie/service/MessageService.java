package com.ie.service;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ie.entities.User;
import com.ie.repository.UserRepository;

@Service
public class MessageService {
	
	@Autowired
	private UserRepository userRepository;

	public void update(String password, User user) throws Exception {
		user.setPassword(MD5(password, user.getUserName()));
		userRepository.save(user);
	}
	
	public String MD5(String password, String userName) throws Exception {
		String hashAlgorithmName = "MD5";
		Object credentials = password;
		Object salt = ByteSource.Util.bytes(userName);
		int hashIterations = 1024;
		
		Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
		return result.toString();
	}
}
