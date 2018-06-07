/**
 * 
 */
package com.ie.service;

import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ie.entities.User;
import com.ie.repository.UserRepository;
import com.ie.util.Encrypt;

/**
 * @author 
 * @Description: 该类的功能描述
 * @date: 2018年6月5日 下午2:52:56 
 */
@Service
public class UserService {

	@Autowired
	UserRepository userDao;
	
	/**
	 * @author: 
	 * @Description: 该函数的功能描述
	 * @date: 2018年6月5日 下午2:58:04
	 */
	public List<User> listAllUsers() throws Exception {
		return userDao.findAll();
	}

	/**
	 * @author: 
	 * @Description: 该函数的功能描述
	 * @date: 2018年6月5日 下午3:01:18
	 */
	public List<User> searchUser(String name) throws Exception {
		return null;
//		return userDao.searchUser(name);
	}

	/**
	 * @author: 
	 * @Description: 该函数的功能描述
	 * @date: 2018年6月5日 下午3:22:22
	 */
	public boolean delete(String id) throws Exception {
		if (userDao.exists(Integer.valueOf(id))) {
			userDao.delete(Integer.valueOf(id));
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author: 
	 * @Description: 该函数的功能描述
	 * @date: 2018年6月5日 下午9:56:58
	 */
	public void save(String userId, String password, String name, String phone, String email) throws Exception {
		User user = new User();
		user.setUserName(userId);
		user.setPassword(MD5(password, userId));
		user.setRoleId(3);
		user.setName(name);
		user.setPhone(phone);
		user.setEmail(email);
		userDao.save(user);
	}
	
	public String MD5(String password, String userName) throws Exception {
		String hashAlgorithmName = "MD5";
		Object credentials = password;
		Object salt = ByteSource.Util.bytes(userName);
		int hashIterations = 1024;
		
		Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
		return result.toString();
	}

	/**
	 * @author: 
	 * @Description: 该函数的功能描述
	 * @date: 2018年6月7日 下午2:04:31
	 */
	public boolean update(String[] userStr) throws Exception {
		User user = new User();
		user.setId(Integer.valueOf(userStr[0]));
		user.setName(userStr[1]);
		user.setPhone(userStr[2]);
		user.setEmail(userStr[3]);
		user.setRoleId(Integer.valueOf(userStr[4]));
		return true;
	}
}
