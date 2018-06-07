/**
 * 
 */
package com.ie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ie.entities.Role;
import com.ie.repository.RoleRepository;

/**
 * @author 
 * @Description: 该类的功能描述
 * @date: 2018年6月7日 下午3:08:49 
 */
@Service
public class RoleService {
	
	@Autowired
	RoleRepository roleDao;

	/**
	 * @author: 
	 * @Description: 该函数的功能描述
	 * @date: 2018年6月7日 下午3:13:42
	 */
	public List<Role> listAllRoles() throws Exception {
		return roleDao.findAll();	
	}

}
