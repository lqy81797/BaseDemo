package com.ie.handler;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ie.entities.Approve;
import com.ie.entities.ItemBank;
import com.ie.entities.User;
import com.ie.service.ApproveService;
import com.ie.util.BaseController;
import com.ie.util.DemoUtil;
import com.ie.util.Page;

/**
 * @author lvqingyang
 * @Description: 该类的功能描述
 * @date: 2018年6月5日 下午2:51:27 
 */
@Controller
@RequestMapping("/ExamController")
public class ExamController extends BaseController {

	@Autowired
	ApproveService approveService;

	@RequestMapping("/goReady")
	public String goReady() {
		return "systemTest/ready";
	}

	@RequestMapping("/ready")
	@ResponseBody
	public String ready(HttpServletRequest request, Page page){
		User user = (User) request.getSession().getAttribute(DemoUtil.SESSION_USER);
		List<Approve> approveList = approveService.getReadyList(user);
		return this.getJsonStr(page, approveList);
	}

	@RequestMapping("/goTest")
	public String goTest(Map<String,Object> map) {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();   
		cal.setTime(date);   
		cal.add(Calendar.HOUR, 1); 
		date = cal.getTime();
		map.put("deadLine", date.toString());
		return "systemTest/exam";
	}

	@RequestMapping("/test")
	@ResponseBody
	public String test(HttpServletRequest request){
		List<ItemBank> itemBankList = approveService.getTestItems();
		return this.getJsonStr(itemBankList);
	}
}