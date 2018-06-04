package com.ie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ie.entities.Approve;

/**
 * @author lvqingyang
 * @Description: 该类的功能描述
 * @date: 2018年6月1日 下午1:48:44 
 */
@Repository
public interface ApproveRepository extends JpaRepository<Approve, String>, JpaSpecificationExecutor<Approve> {

	@Query(value="from Approve a where status = 0")
	public List<Approve> listAllTodo();
	
	public List<Approve> findByUserId(String userName);
}

