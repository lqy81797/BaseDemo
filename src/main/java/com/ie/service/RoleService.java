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

	/**
	 * @author: lvqingyang
	 * @Description: 该函数的功能描述
	 * @date: 2018年6月7日 下午6:52:30
	 * @param:描述1描述
	 * @return：返回结果描述
	 */
	public boolean update(String id, String name) throws Exception {
		Role role = new Role();
		role.setId(Integer.valueOf(id));
		role.setName(name);
		roleDao.save(role);
		return true;
	}

}
