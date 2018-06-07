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
		return "role/manage";
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

		//		if(result) {
		//			//log
		//		} else {
		//			//log
		//		}
		logger.debug("修改角色成功");
		return "user/manage";
	}
}
