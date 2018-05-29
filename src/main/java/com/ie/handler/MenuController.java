/**
 * 
 */
package com.ie.handler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ie.entities.Menu;
import com.ie.entities.Role;
import com.ie.entities.User;
import com.ie.service.MenuService;
import com.ie.util.DemoUtil;
import com.ie.util.JacksonInstance;

/**
 * @author lvqingyang
 * @Description: 菜单Controller
 * @date: 2018年5月27日 下午5:36:27 
 */
@Controller
@RequestMapping("/MenuController")
public class MenuController {
	@Autowired
	private MenuService menuService;
	/**
	 * @author: lvqingyang
	 * @Description: 菜单集合转换json
	 * @date: 2018年5月26日 下午4:01:39
	 * @param:描述1描述
	 * @return：返回结果描述
	 */
	@RequestMapping(value="/getMenuJson",method=RequestMethod.GET)
	@ResponseBody
	public String getMenuJson(HttpServletRequest request, Menu menu){
		int param1 = 0, param2 = 0, param3 = 0;
		HttpSession session = request.getSession();
		//获取登录用户的角色role
		User user = (User) session.getAttribute(DemoUtil.SESSION_USER);
		Role role = menuService.getById(user.getRoleId());
		if(role.getId() == DemoUtil.SYS_ROLE_ADMIN){ 
			param1 = 12;
			param2 = 1;
			param3 = 123;
		}else if(role.getId() == DemoUtil.SYS_ROLE_TEACHER){
			param1 = 12;
			param2 = 2;
			param3 = 123;
		}else if(role.getId() == DemoUtil.SYS_ROLE_STUDENT){
			param1 = 123;
			param2 = 3;
			param3 = 23;
		}
		//查询全部菜单数据
		List<Menu> menuList = menuService.listAllMenu(param1, param2, param3);
		//将查询的菜单数据转换成ligertree展示的数据
		List<MenuData> menuDataList = null; 
		if(menuList!=null && menuList.size()>0){
			menuDataList = convertMenuList(menuList);
		}
		//将菜单展示集合转换成json
		return getJsonStr(menuDataList);
	}

	/**
	 * @author: lvqingyang
	 * @Description: 将查询出数据转换成json格式  
	 * @date: 2018年5月26日 下午3:54:10
	 */
	public String getJsonStr(List list){
		ObjectMapper mapper = JacksonInstance.getMapperInstance(false);
		String rst = "";
		try {
			rst = mapper.writeValueAsString(list);//转换为JSON
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return rst;
	}

	/**
	 * @author: lvqingyang
	 * @Description: 将查询的菜单数据转换成ligertree展示的数据
	 * @date: 2018年5月26日 下午5:46:05
	 */
	private List<MenuData> convertMenuList(List<Menu> menuList) {
		List<MenuData> menuDataList = new ArrayList<MenuData>();
		for(Menu menu : menuList){
			MenuData menuData = new MenuData();
			menuData.setId(menu.getId());
			menuData.setPid(menu.getParentId());
			menuData.setText(menu.getName());
			menuData.setSrc(menu.getUrl());
			menuData.setViewtype(menu.getViewtype());
			menuDataList.add(menuData);
		}
		return menuDataList;
	}

	//对应ligertree展示菜单数据的内部类
	public class MenuData{
		private int  id;
		private String  pid;
		private String  text;
		private String  src;
		private Integer viewtype;
		private Boolean isExpand;
		private Boolean ischecked;

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getPid() {
			return pid;
		}
		public void setPid(String string) {
			this.pid = string;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		public String getSrc() {
			return src;
		}
		public void setSrc(String src) {
			this.src = src;
		}
		public Boolean getIschecked() {
			return ischecked;
		}
		public void setIschecked(Boolean ischecked) {
			this.ischecked = ischecked;
		}
		public Integer getViewtype() {
			return viewtype;
		}
		public void setViewtype(Integer viewtype) {
			this.viewtype = viewtype;
		}
		public Boolean getIsExpand() {
			return isExpand;
		}
		public void setIsExpand(Boolean isExpand) {
			this.isExpand = isExpand;
		}

	}
}
