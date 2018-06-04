/**
 * 
 */
package com.ie.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ie.entities.Approve;
import com.ie.repository.ApproveRepository;

/**
 * @author lvqingyang
 * @Description: 该类的功能描述
 * @date: 2018年6月1日 下午2:18:30 
 */
@Service
public class ApproveService {
	
	@Autowired
	private ApproveRepository approveDao;

	/**
	 * @author: lvqingyang
	 * @return 
	 * @Description: 该函数的功能描述
	 * @date: 2018年6月1日 下午2:26:17
	 */
	public Approve addApprove(String subject, String remark, String userId, int status) {
		Approve approve = new Approve();
		approve.setSubject(subject);
		approve.setRemark(remark);
		approve.setUserId(userId);
		approve.setStatus(status);
		approve.setCreateTime(new Date());
		return approveDao.save(approve);
	}

	/**
	 * @author: lvqingyang
	 * @Description: 该函数的功能描述
	 * @date: 2018年6月1日 下午3:15:49
	 */
	public List<Approve> listAllTodo() {
		return approveDao.listAllTodo();
	}

	/**
	 * @author: lvqingyang
	 * @Description: 该函数的功能描述
	 * @date: 2018年6月1日 下午3:26:51
	 */
	public List<Approve> listAllApproving(String userName) {
		return approveDao.findByUserId(userName);
	}

}
