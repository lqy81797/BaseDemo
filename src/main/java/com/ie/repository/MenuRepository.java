/**
 * 
 */
package com.ie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ie.entities.Menu;

/**
 * @author lvqingyang
 * @Description: 该类的功能描述
 * @date: 2018年5月26日 下午5:17:47 
 */
public interface MenuRepository extends JpaRepository<Menu, String>, JpaSpecificationExecutor<Menu> {
	@Query(value="from Menu m where viewtype = ?1 or viewtype = ?2 or viewtype = ?3")
	public List<Menu> listAllMenu(int param1, int param2, int param3);
}
