package com.ie.handler;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ie.entities.User;
import com.ie.service.ShiroService;
import com.ie.util.BaseController;
import com.ie.util.DemoUtil;
@Controller
@RequestMapping("/shiro")
public class ShiroHandler extends BaseController {
	
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
			@RequestParam("password") String password, HttpServletRequest request, 
			Map<String,Object> map){
		Subject currentUser = SecurityUtils.getSubject();
//		User u = shiroService.find(username);
//		if(u==null) {
//			map.put("erroInfo", "用户不存在！");
//			return "redirect:/login.jsp";
//		} else
		if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);
            try {
                currentUser.login(token);
                User user = shiroService.getUserByUserName(username);
                SecurityUtils.getSubject().getSession().setAttribute(DemoUtil.SESSION_USER, user);
                logger.debug("登录成功");
                String errorString = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);		
        		String msg = "";
        		Class<?> error = null;
        		try {
        			if (errorString != null) {
        				error = Class.forName(errorString);
        			}
        		} catch (ClassNotFoundException e) {
        			logger.error(e.getMessage());
        		}
        		if (error != null) {
        			if (error.equals(UnknownAccountException.class)){
        				msg = "登录失败，未知帐号错误！";
        			} else if (error.equals(IncorrectCredentialsException.class)){
        				msg = "登录失败，用户名或密码错误！";
        			} else if (error.equals(LockedAccountException.class)) {
        				msg = "登录失败，距离上次登录失败的时间过短！";
        			} else {
        				msg = "登录失败，其他错误！";
        			}
        		}
        		if(msg!=null && !"".equals(msg)){
        			//提示信息
        			map.put("erroInfo", msg);
        			return "redirect:/login.jsp";
        		}else{
        			return "redirect:/list.jsp";
        		}
            } 
            catch (Exception ae) {
            	logger.error(ae.getMessage());
            	return "redirect:/login.jsp";
            }
        }
		return "redirect:/list.jsp";
	}
	
	@RequestMapping("/logout")
	@ResponseBody
	public String logout(HttpSession session) {
		if (session != null) {
			session.invalidate();
			logger.debug("注销成功");
		}
		return this.getJsonStr(new ArrayList<String>());
	}
}
