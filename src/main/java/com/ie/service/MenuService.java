/**
 * 
 */
package com.ie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ie.repository.MenuRepository;
import com.ie.repository.RoleRepository;
import com.ie.entities.Menu;
import com.ie.entities.Role;
/**
 * @author lvqingyang
 * @Description: 该类的功能描述
 * @date: 2018年5月26日 下午5:06:06 
 */
@Service
public class MenuService {
	@Autowired
	private MenuRepository menuDao;
	
	@Autowired
	private RoleRepository roleDao;
	
	public List<Menu> listAllMenu(int param1, int param2, int param3) {
		return menuDao.listAllMenu(param1, param2, param3);
	}
	
	public Role getById(int id){
		return roleDao.getById(id);
	};
}
