/**
 * 
 */
package com.ie.service;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ie.entities.Approve;
import com.ie.repository.ApproveRepository;

/**
 * @author lvqingyang
 * @Description: 该类的功能描述
 * @date: 2018年6月1日 上午11:24:44 
 */
@Service
public class WorkflowService {

	@Autowired
	ApproveRepository approveDao;

	@Autowired
	ProcessEngine processEngine;

	public String startProcess(String userName, String id) {
		String key = "exam";
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("inputUser", userName);
		String objId = key + "." + id;
		variables.put("objId", objId);
		ProcessInstance instance = processEngine.getRuntimeService().startProcessInstanceByKey(key, objId, variables);
		Task task = processEngine.getTaskService().createTaskQuery()
				.processInstanceId(instance.getProcessInstanceId())
				.singleResult();
		return task.getId();
	}

	/**
	 * @author: lvqingyang
	 * @Description: 该函数的功能描述
	 * @date: 2018年6月4日 下午1:54:56
	 */
	public void saveSubmitTask(String taskId) {		
		processEngine.getTaskService().complete(taskId);
	}

	/**
	 * @author: lvqingyang
	 * @Description: 该函数的功能描述
	 * @date: 2018年6月4日 下午3:05:34
	 */
	public String getTaskId(String id) {
		String key = "exam";
		String objId = key + "." + id;
		Task task = processEngine.getTaskService().createTaskQuery()
				.processVariableValueEquals("objId", objId)
				.taskAssignee("teacher")
				.singleResult();
		return task.getId();
	}

	/**
	 * @author: lvqingyang
	 * @Description: 该函数的功能描述
	 * @date: 2018年6月4日 下午9:06:29
	 */
	public void setApprove(String id , int status) {
		Approve approve = approveDao.findOne(Integer.valueOf(id));
		approve.setStatus(1);
		approveDao.save(approve);
	}

}
