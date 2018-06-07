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

	/**
	 * @author: lvqingyang
	 * @Description: 修改密码
	 * @date: 2018年6月7日 下午9:34:03
	 */
	public void update(String password, User user) throws Exception {
		user.setPassword(MD5(password, user.getUserName()));
		userRepository.save(user);
	}
	
	/**
	 * @author: lvqingyang
	 * @Description: MD5加密
	 * @date: 2018年6月7日 下午9:34:16
	 */
	public String MD5(String password, String userName) throws Exception {
		String hashAlgorithmName = "MD5";
		Object credentials = password;
		Object salt = ByteSource.Util.bytes(userName);
		int hashIterations = 1024;
		
		Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
		return result.toString();
	}
}
