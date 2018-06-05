/**
 * 
 */
package com.ie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ie.entities.User;
import com.ie.repository.UserRepository;

/**
 * @author lvqingyang
 * @Description: 该类的功能描述
 * @date: 2018年6月5日 下午2:52:56 
 */
@Service
public class UserService {

	@Autowired
	UserRepository userDao;
	
	/**
	 * @author: lvqingyang
	 * @Description: 该函数的功能描述
	 * @date: 2018年6月5日 下午2:58:04
	 */
	public List<User> listAllUsers() {
		return userDao.findAll();
	}

	/**
	 * @author: lvqingyang
	 * @Description: 该函数的功能描述
	 * @date: 2018年6月5日 下午3:01:18
	 */
	public List<User> searchUser(String name) {
		return null;
//		return userDao.searchUser(name);
	}

	/**
	 * @author: lvqingyang
	 * @Description: 该函数的功能描述
	 * @date: 2018年6月5日 下午3:13:47
	 * @param:描述1描述
	 * @return：返回结果描述
	 */
	public boolean update() {
		// TODO 自动生成的方法存根
		return false;
	}

	/**
	 * @author: lvqingyang
	 * @Description: 该函数的功能描述
	 * @date: 2018年6月5日 下午3:22:22
	 */
	public boolean delete(String id) {
		if (userDao.exists(id)) {
			userDao.delete(id);
			return true;
		} else {
			return false;
		}
	}
}
