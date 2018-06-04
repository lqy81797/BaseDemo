/**
 * 
 */
package com.ie.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ie.entities.Approve;
import com.ie.entities.User;
import com.ie.service.ApproveService;
import com.ie.service.ItemBankService;
import com.ie.util.BaseController;
import com.ie.util.DemoUtil;

/**
 * @author lvqingyang
 * @Description: 该类的功能描述
 * @date: 2018年6月1日 下午2:17:45 
 */
@Controller
@RequestMapping("/ApproveController")
public class ApproveController extends BaseController {
	@Autowired
	private ApproveService approveService;

	@Transactional
	@RequestMapping("/add")
	public String add(HttpServletRequest request, Map<String,Object> map) {
		String subject = request.getParameter("subject");
		String remark = request.getParameter("remark");
		User user = (User) request.getSession().getAttribute(DemoUtil.SESSION_USER);
		String userId = user.getUserName();
		int status = 0;
		Approve approve = approveService.addApprove(subject, remark, userId, status);
		map.put("approve", approve);
		return "approve/my";
	}
	
	@RequestMapping("/todo")
	@ResponseBody
	public String todo() {
		List<Approve> approveList = approveService.listAllTodo();
		return this.getJsonStr(approveList);
	}
	
	@RequestMapping("/approving")
	@ResponseBody
	public String approving(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(DemoUtil.SESSION_USER);
		List<Approve> approveList = approveService.listAllApproving(user.getUserName());
		return this.getJsonStr(approveList);
	}
	
}
