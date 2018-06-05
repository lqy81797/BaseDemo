package com.ie.handler;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value="/RegisterController")
public class RegisterController {
	
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
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(){
		
		return "redirect:/login.jsp";
	}
	
}
