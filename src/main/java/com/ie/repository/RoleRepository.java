/**
 * 
 */
package com.ie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ie.entities.Role;

/**
 * @author lvqingyang
 * @Description: 该类的功能描述
 * @date: 2018年5月26日 下午12:02:00 
 */
public interface RoleRepository extends JpaRepository<Role, String>,JpaSpecificationExecutor<Role>{

	public Role getById(int id);
}
