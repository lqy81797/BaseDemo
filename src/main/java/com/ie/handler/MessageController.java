package com.ie.handler;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ie.entities.User;
import com.ie.service.MessageService;
import com.ie.util.DemoUtil;  

@Controller
@RequestMapping("/MessageController")
public class MessageController  {  
    private static final long serialVersionUID = 1L; 
    
    @Autowired
    MessageService messageService;
         
 
    @RequestMapping("/update")
    public ModelAndView update(HttpServletRequest request, Map<String,Object> map ) throws ServletException, IOException {  
    
    	User user = (User) request.getSession().getAttribute(DemoUtil.SESSION_USER);  
        String newPassword=request.getParameter("renewPas");  
        String nowPassword = request.getParameter("nowPas");
                 
        messageService.update(newPassword, user);
                  
        return new ModelAndView("redirect:/MessageController/goAdd.do");
 
    }  
    
    
    @RequestMapping("/goAdd")
    public String goAdd(HttpServletRequest request, Map<String,Object> map ) throws ServletException, IOException {  
    	User user = (User) request.getSession().getAttribute(DemoUtil.SESSION_USER);
    	map.put("userId", user.getUserName());
    	map.put("name", user.getName());
    	map.put("phone", user.getPhone());
    	map.put("password", user.getPassword());
    	map.put("email", user.getEmail());
    	
        return "user/message";
 
    }  
    
  
}  