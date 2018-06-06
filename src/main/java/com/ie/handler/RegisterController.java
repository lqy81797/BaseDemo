package com.ie.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ie.service.UserService;

@Controller
@RequestMapping(value="/RegisterController")
public class RegisterController {
	
	@Autowired
	UserService userService;
	/**
	 * 进入注册页面
	 */
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(){
		return "redirect:/register.jsp";
	}
	
	/**
	 * 注册用户
	 */
	@Transactional
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(HttpServletRequest request){
		String userId = request.getParameter("loginID");
		String password = request.getParameter("password");
		String name = request.getParameter("realName");
		String phone = request.getParameter("mobilePhone");
		String email = request.getParameter("email");
		userService.save(userId, password, name, phone, email);
		return "redirect:/login.jsp";
	}
	
}
