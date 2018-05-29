package com.ie.test;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.hibernate.ejb.QueryHints;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ie.entities.Department;
import com.ie.repository.DepartmentRepository;

public class TestSuite {
	private ApplicationContext ctx=null;
	private DepartmentRepository departmentRepository=null;
	private EntityManagerFactory entityManagerFactory=null;
	{
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		entityManagerFactory=ctx.getBean(EntityManagerFactory.class);
		departmentRepository=ctx.getBean(DepartmentRepository.class);
	}
	@Test
	public void testDatasource() throws SQLException {
		DataSource dataSource=ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}
	@Test
	public void testJpaSecondCache() {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("FROM Department");
		List<Department> departments=query.setHint(QueryHints.HINT_CACHEABLE, true).getResultList();
		entityManager.close();
		entityManager=entityManagerFactory.createEntityManager();
		query=entityManager.createQuery("FROM Department");
		departments=query.setHint(QueryHints.HINT_CACHEABLE, true).getResultList();
		entityManager.close();
	}
	@Test
	public void testDeprtmentSecondCache() {
		List<Department> departments=departmentRepository.getAll();
		departments=departmentRepository.getAll();
	}
}
