package com.ie.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ie.entities.Role;
import com.ie.service.RoleService;
import com.ie.util.BaseController;
import com.ie.util.Page;

/**
 * @author 
 * @Description: 该类的功能描述
 * @date: 2018年6月7日 下午3:07:46 
 */
@Controller
@RequestMapping("/RoleController")
public class RoleController extends BaseController {

	@Autowired
	private RoleService roleService;

	@RequestMapping("/goManage")
	public String goManage() {
		logger.debug("进入角色管理页面");
		return "role/manageRole";
	}

	@RequestMapping(value = "/management", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String manageRole(Page page) {
		try {
			List<Role> roleList = roleService.listAllRoles();
			logger.debug("生成角色列表");
			return this.getJsonStr(page, roleList);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@Transactional
	@RequestMapping("/update")
	public String updateRole(HttpServletRequest request) {
		try{
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String isUse = request.getParameter("isUse");

			boolean result = roleService.update(id, name, isUse);
			if(result) {
				logger.debug("修改角色成功");
			} else {
				logger.debug("修改角色失败");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "role/manage";
	}
	
	@Transactional
	@RequestMapping("/delete")
	public String deleteRole(HttpServletRequest request) {
		try {
			String id = request.getParameter("id");
			boolean result = roleService.delete(id);
			if(result) {
				logger.debug("删除角色成功");
			} else {
				logger.debug("删除角色失败");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "user/manage";
	}
	
}
