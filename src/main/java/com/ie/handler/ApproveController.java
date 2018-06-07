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
import com.ie.entities.ItemBank;
import com.ie.entities.User;
import com.ie.service.ApproveService;
import com.ie.service.ItemBankService;
import com.ie.util.BaseController;
import com.ie.util.DemoUtil;
import com.ie.util.Page;

/**
 * @author 
 * @Description: 该类的功能描述
 * @date: 2018年6月1日 下午2:17:45 
 */
@Controller
@RequestMapping("/ApproveController")
public class ApproveController extends BaseController {
	@Autowired
	private ApproveService approveService;

	@RequestMapping("/goApply")
	public String goApply() {
		logger.debug("进入申请考试页面");
		return "student/approveForStudent";
	}

	@RequestMapping("/goTodo")
	public String goTodo() {
		logger.debug("进入考试审批页面");
		return "teacher/approveForTeacher";
	}

	@RequestMapping("/goAddApply")
	public String goAddApply() {
		logger.debug("进入新增申请页面");
		return "student/addApprovement";
	}

	@Transactional
	@RequestMapping("/add")
	public String add(HttpServletRequest request, Map<String,Object> map) {
		try{
			String subject = request.getParameter("subject");
			String remark = request.getParameter("remark");
			User user = (User) request.getSession().getAttribute(DemoUtil.SESSION_USER);
			String userId = user.getUserName();
			int status = 0;
			Approve approve = approveService.addApprove(subject, remark, userId, status);
			logger.debug("新增申请成功");
			map.put("approve", approve);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "student/addApprovement";
	}

	@RequestMapping("/todo")
	@ResponseBody
	public String todo(Page page) {
		try{
			List<Approve> approveList = approveService.listAllTodo();
			logger.debug("生成考试审批列表");
			return this.getJsonStr(page, approveList);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@RequestMapping("/approving")
	@ResponseBody
	public String approving(Page page, HttpServletRequest request) {
		try{
			User user = (User) request.getSession().getAttribute(DemoUtil.SESSION_USER);
			List<Approve> approveList = approveService.listAllApproving(user.getUserName());
			approveList = formatDate(approveList);
			logger.debug("生成我的申请列表");
			return this.getJsonStr(page, approveList);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	public List<Approve> formatDate(List<Approve> approve) {
		try{
			for(Approve app : approve) {
				app.setTime(app.getCreateTime().toString());
			}
			return approve;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}

	}
}
