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
	 * @Description: 列出全部角色
	 * @date: 2018年6月7日 下午3:13:42
	 */
	public List<Role> listAllRoles() throws Exception {
		return roleDao.findAll();	
	}

	/**
	 * @author: lvqingyang
	 * @param isUse 
	 * @Description: 修改角色
	 * @date: 2018年6月7日 下午6:52:30
	 */
	public boolean update(String id, String name, String isUse) throws Exception {
		Role role = new Role();
		role.setId(Integer.valueOf(id));
		role.setName(name);
		role.setIsUse(Integer.valueOf(isUse));
		roleDao.save(role);
		return true;
	}

	/**
	 * @author: lvqingyang
	 * @Description: 删除角色
	 * @date: 2018年6月7日 下午6:58:18
	 */
	public boolean delete(String id) {
		if (roleDao.exists(Integer.valueOf(id))) {
			roleDao.delete(Integer.valueOf(id));
			return true;
		} else {
			return false;
		}
	}

}
