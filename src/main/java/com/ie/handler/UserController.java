package com.ie.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ie.entities.User;
import com.ie.service.UserService;
import com.ie.util.BaseController;
import com.ie.util.Page;

/**
 * @author lvqingyang
 * @Description: 该类的功能描述
 * @date: 2018年6月5日 下午2:51:36 
 */
@Controller
@RequestMapping("/UserController")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/goManage")
	public String goManage() {
		return "user/manage";
	}
	
	@RequestMapping(value = "/management", method = {RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String manageUser(Page page) {
		List<User> userList = userService.listAllUsers();
		return this.getJsonStr(page, userList);
	}
	
	@RequestMapping("/search")
	@ResponseBody
	public String searchUser(@RequestParam(value="name") String name, HttpServletRequest request, Page page){
		List<User> userList = userService.searchUser(name);
		return this.getJsonStr(page, userList);
	}
	
	@Transactional
	@RequestMapping("/update")
	public String updateUser(HttpServletRequest request) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String roleId = request.getParameter("roleId");
		
		String[] user = {id, name, phone, email, roleId};
		boolean result = userService.update(user);
		if(result) {
			//log
		} else {
			//log
		}
		return "user/manage";
	}
	
	@Transactional
	@RequestMapping("/delete")
	public String deleteUser(HttpServletRequest request) {
		String id = request.getParameter("id");
		boolean result = userService.delete(id);
		if(result) {
			//log
		} else {
			//log
		}
		return "user/manage";
	}
}
