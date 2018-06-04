/**
 * 
 */
package com.ie.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ie.entities.Approve;
import com.ie.entities.User;
import com.ie.repository.ApproveRepository;
import com.ie.util.DemoUtil;

/**
 * @author lvqingyang
 * @Description: 该类的功能描述
 * @date: 2018年6月1日 上午11:24:44 
 */
@Service
public class WorkflowService {
	
	@Autowired
	private ApproveRepository approveDao;
	
	@Autowired
	private TaskService taskService;

	@Autowired
	private RuntimeService runtimeService;

	public void startProcess(HttpServletRequest request, String id) {
		Approve approve = approveDao.findOne(id);
		// 2：更新请假单的请假状态从0变成1（初始录入-->审核中）
		// 3：使用当前对象获取到流程定义的key（对象的名称就是流程定义的key）
		// String key = leaveBill.getClass().getSimpleName();
		String key = "exam";
		/**
		 * 4：从Session中获取当前任务的办理人，使用流程变量设置下一个任务的办理人 inputUser是流程变量的名称， 获取的办理人是流程变量的值
		 */
		User user = (User)request.getSession().getAttribute(DemoUtil.SESSION_USER);
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("inputUser", user.getUserName());// 表示惟一用户
		/**
		 * 5： (1)使用流程变量设置字符串（格式：LeaveBill.id的形式），通过设置，让启动的流程（流程实例）关联业务
		 * (2)使用正在执行对象表中的一个字段BUSINESS_KEY（Activiti提供的一个字段），让启动的流程（流程实例）关联业务
		 */
		// 格式：LeaveBill.id的形式（使用流程变量）
		String objId = key + "." + id;
		variables.put("objId", objId);
		// 6：使用流程定义的key，启动流程实例，同时设置流程变量，同时向正在执行的执行对象表中的字段BUSINESS_KEY添加业务数据，同时让流程关联业务
		runtimeService.startProcessInstanceByKey(key, objId, variables);
	}

	/**
	 * @author: lvqingyang
	 * @Description: 该函数的功能描述
	 * @date: 2018年6月1日 下午4:01:14
	 */
	public void saveSubmitTask(HttpServletRequest request, String id, String taskId, String remark) {
		Task task = taskService.createTaskQuery()//
				.taskId(taskId)// 使用任务ID查询
				.singleResult();
		String processInstanceId = task.getProcessInstanceId();
		User user = (User)request.getSession().getAttribute(DemoUtil.SESSION_USER);
		Authentication.setAuthenticatedUserId(user.getUserName());
		taskService.addComment(taskId, processInstanceId, remark);
		
		Map<String, Object> variables = new HashMap<String, Object>();
			variables.put("outcome", "批准");

		// 3：使用任务ID，完成当前人的个人任务，同时流程变量
		taskService.complete(taskId, variables);
	}
}
