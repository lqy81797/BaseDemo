package com.ie.service;

import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.ie.entities.User;
import com.ie.repository.UserRepository;

public class ShiroService {
	
	@Autowired
	private UserRepository userDao;
	
	@RequiresRoles({"admin"})
	public void testMethod() {
		Session session=SecurityUtils.getSubject().getSession();
		System.out.println(session.getAttribute("key"));
		System.out.println("shiro...,time:"+new Date());
	}
	
	public User getUserByUserName(String userId) throws Exception {
		return userDao.getByUserName(userId);
	}

	/**
	 * @author: 
	 * @Description: 通过用户名找到用户
	 * @date: 2018年6月5日 下午9:43:21
	 */
	public User find(String userName) throws Exception {
		User user = userDao.getByUserName(userName);
		if (user != null) {
			return user;
		} else {
			return null;
		}
	}
}
