/**
 * 
 */
package com.ie.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ie.entities.Approve;
import com.ie.entities.ItemBank;
import com.ie.entities.User;
import com.ie.repository.ApproveRepository;
import com.ie.repository.ItemBankRepository;

/**
 * @author 
 * @Description: 该类的功能描述
 * @date: 2018年6月1日 下午2:18:30 
 */
@Service
public class ApproveService {
	
	@Autowired
	private ApproveRepository approveDao;
	
	@Autowired
	private ItemBankRepository itemBankDao;

	/**
	 * @author: 
	 * @return 
	 * @Description: 该函数的功能描述
	 * @date: 2018年6月1日 下午2:26:17
	 */
	public Approve addApprove(String subject, String remark, String userId, int status) throws Exception {
		Approve approve = new Approve();
		approve.setSubject(subject);
		approve.setRemark(remark);
		approve.setUserId(userId);
		approve.setStatus(status);
		approve.setCreateTime(new Date());
		return approveDao.save(approve);
	}

	/**
	 * @author: 
	 * @Description: 该函数的功能描述
	 * @date: 2018年6月1日 下午3:15:49
	 */
	public List<Approve> listAllTodo() throws Exception {
		return approveDao.listAllTodo();
	}

	/**
	 * @author: 
	 * @Description: 该函数的功能描述
	 * @date: 2018年6月1日 下午3:26:51
	 */
	public List<Approve> listAllApproving(String userName) throws Exception {
		return approveDao.findByUserId(userName);
	}

	/**
	 * @author: 
	 * @Description: 该函数的功能描述
	 * @date: 2018年6月6日 下午9:07:13
	 */
	public List<Approve> getReadyList(User user) throws Exception {
		return approveDao.getReadyList(user.getUserName());
	}

	/**
	 * @author: 
	 * @Description: 该函数的功能描述
	 * @date: 2018年6月7日 上午9:24:10
	 */
	public List<ItemBank> getTestItems() throws Exception {
		return itemBankDao.getTest();
	}

}
