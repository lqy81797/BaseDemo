package com.ie.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ie.entities.User;
import com.ie.service.WorkflowService;
import com.ie.util.BaseController;
import com.ie.util.DemoUtil;

/**
 * @author 
 * @Description: 该类的功能描述
 * @date: 2018年6月1日 上午11:23:32 
 */
@Controller
@RequestMapping("/WorkflowController")
public class WorkflowController extends BaseController {
	@Autowired
	private WorkflowService workflowService;

	// 启动流程
	@RequestMapping("/startProcess")
	public String startProcess(HttpServletRequest request, @RequestParam("id") String id) {
		// 更新请假状态，启动流程实例，让启动的流程实例关联业务
		try {
			User user = (User) request.getSession().getAttribute(DemoUtil.SESSION_USER);
			String userName = user.getUserName();
			String taskId = workflowService.startProcess(userName, id);
			workflowService.saveSubmitTask(taskId);
			workflowService.setApprove(id, -1);
			logger.debug("发起流程成功");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "student/approveForStudent";
	}

	//提交任务
	@RequestMapping("/submit")
	public String submitTask(HttpServletRequest request, String id) {
		try {
			String taskId = workflowService.getTaskId(id);
			workflowService.saveSubmitTask(taskId);
			workflowService.setApprove(id, 1);
			logger.debug("审批成功");
		}
			catch (Exception e) {
				logger.error(e.getMessage());
			}
			return "teacher/approveForTeacher";
		}
	}
