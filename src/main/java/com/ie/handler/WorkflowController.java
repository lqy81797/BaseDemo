/**
 * 
 */
package com.ie.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ie.service.WorkflowService;

/**
 * @author lvqingyang
 * @Description: 该类的功能描述
 * @date: 2018年6月1日 上午11:23:32 
 */
@Controller
@RequestMapping("/WorkflowController")
public class WorkflowController {
	@Autowired
	private WorkflowService workflowService;

	// 启动流程
	@RequestMapping("/startProcess")
	@ResponseBody
	public String startProcess(HttpServletRequest request, @RequestParam("id") String id) {
		// 更新请假状态，启动流程实例，让启动的流程实例关联业务
		workflowService.startProcess(request, id);
		return "approve/my";
	}

	//提交任务
	@RequestMapping("/submit")
	@ResponseBody
	public String submitTask(HttpServletRequest request, String taskId) {
		String remark = request.getParameter("remark");
		String id = request.getParameter("id");

		workflowService.saveSubmitTask(request, id, taskId, remark);
		return "approve/list";
	}
}
