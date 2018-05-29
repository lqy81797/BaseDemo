package com.ie.handler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ie.entities.Employee;
import com.ie.service.DepartmentService;
import com.ie.service.EmployeeService;

@Controller
public class EmployeeHandler {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
	@Transactional(readOnly=true)
	@RequestMapping(value="/emp",method=RequestMethod.GET)
	public String input(Map<String,Object> map) {
		map.put("departments", departmentService.getAll());
		map.put("employee", new Employee());
		return "emp/input";
	}
	@Transactional(readOnly=true)
	@RequestMapping("/emps")
	public String list(@RequestParam(value="pageNo",required=false,defaultValue="1")String pageNoStr,
			Map<String, Object> map) {
		int pageNo=1;
		try {
			pageNo=Integer.parseInt(pageNoStr);
			if(pageNo<1)pageNo=1;
		} catch (Exception e) {}
		Page<Employee> page=employeeService.getPage(pageNo, 5);
		map.put("page", page);
		return "emp/list";
	}
	@Transactional(readOnly=true)
	@ResponseBody//直接向页面发送结果0或者1
	@RequestMapping(value="/ajaxValidateLastName",method=RequestMethod.POST)
	public String validateLastName(@RequestParam(value="lastName",required=true)String lastName) {
		Employee employee=employeeService.getByLastName(lastName);
		if(employee==null)return "0";
		else return "1";
	}
	/**
	 * REST full
	 * 添加insert：POST
	 * 删除delete:DELETE
	 * 修改update：PUT
	 * 查询select：GET
	 */
	@Transactional
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public String save(Employee employee) {
		employeeService.save(employee);
		return "redirect:/emps";
	}
	@Transactional(readOnly=true)
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	public String input(@PathVariable("id")Integer id,Map<String,Object> map) {
		map.put("employee", employeeService.get(id));
		map.put("departments", departmentService.getAll());
		return "emp/input";
	}
	@Transactional(readOnly=true)
	@ModelAttribute
	public void getEmployee(@RequestParam(value="id",required=false)Integer id,Map<String,Object> map) {
		if(id!=null) {
			Employee employee=employeeService.get(id);
			employee.setDepartment(null);//把关联对象指向save方法新的传入对象
			map.put("employee",employee );
		}
	}
	@Transactional
	@RequestMapping(value="/emp/{id}",method=RequestMethod.PUT)
	public String update(Employee employee) {
		employeeService.save(employee);
		return "redirect:/emps";
	}
	@Transactional
	@RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id")Integer id) {
		employeeService.delete(id);
		return "redirect:/emps";
	}
}
