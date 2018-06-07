package com.ie.handler;

import java.text.SimpleDateFormat;
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
 * @author 
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
		logger.debug("进入准备考试页面");
		return "systemTest/ready";
	}

	@RequestMapping("/ready")
	@ResponseBody
	public String ready(HttpServletRequest request, Page page){
		try{
			User user = (User) request.getSession().getAttribute(DemoUtil.SESSION_USER);
			List<Approve> approveList = approveService.getReadyList(user);
			logger.debug("生成我的考试列表");
			return this.getJsonStr(page, approveList);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("deprecation")
	@RequestMapping("/goTest")
	public String goTest(Map<String,Object> map) {
		try{
			Date date = new Date();
			date.setHours(date.getHours() + 1);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String dateString = formatter.format(date);
			map.put("deadLine", dateString);
			logger.debug("进入考试页面");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "systemTest/exam";
	}

	@RequestMapping(value="/test",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String test(HttpServletRequest request){
		try{
			List<ItemBank> itemBankList = approveService.getTestItems();
			logger.debug("生成试卷");
			return this.getJsonStr(itemBankList);
		}catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}
	
	@RequestMapping("/goSubmit")
	public String goSubmit(HttpServletRequest request){
		logger.debug("进入考试成绩页面");
		return "systemTest/finish";
	}
}