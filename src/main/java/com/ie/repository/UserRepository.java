/**
 * 
 */
package com.ie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ie.entities.User;

/**
 * @author lvqingyang
 * @Description: 用户数据库操作
 * @date: 2018年5月26日 下午12:02:47 
 */
public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User>{
	//通过userId获取user对象
	public User getByUserName(String userName);
}
