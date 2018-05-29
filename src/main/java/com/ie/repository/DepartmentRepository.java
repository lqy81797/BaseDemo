package com.ie.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import com.ie.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	//使用二级缓存
	@QueryHints(value= {@QueryHint(name=org.hibernate.ejb.QueryHints.HINT_CACHEABLE,value="true")})
	@Query("FROM Department")
	List<Department> getAll();
}
