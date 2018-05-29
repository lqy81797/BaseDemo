package com.ie.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ie.entities.User;
import com.ie.service.ShiroService;
import com.ie.util.DemoUtil;
@Controller
@RequestMapping("shiro")
public class ShiroHandler {
	
	@Autowired
	private ShiroService shiroService;
	
	@RequestMapping("/testShiroAnnotation")
	public String testShiroAnnotation(HttpSession session) {
		session.setAttribute("key", "1234567890");
		shiroService.testMethod();
		return "redirect:/list.jsp";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam("username") String username, 
			@RequestParam("password") String password){
		Subject currentUser = SecurityUtils.getSubject();
		
		if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);
            try {
            	System.out.println("1. " + token.hashCode());
                currentUser.login(token);
                User user = shiroService.getUserByUserName(username);
                SecurityUtils.getSubject().getSession().setAttribute(DemoUtil.SESSION_USER, user);
            } 
            catch (AuthenticationException ae) {
            	System.out.println(ae.getMessage());
            }
        }
		return "redirect:/list.jsp";
	}
}
