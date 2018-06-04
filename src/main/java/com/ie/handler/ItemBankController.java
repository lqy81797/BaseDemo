package com.ie.handler;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ie.entities.ItemBank;
import com.ie.entities.User;
import com.ie.service.ItemBankService;
import com.ie.util.BaseController;
import com.ie.util.DemoUtil;

/**
 * @author lvqingyang
 * @Description: 题库Controller
 * @date: 2018年5月28日 下午6:04:21 
 */
@Controller
@RequestMapping("/ItemBankController")
public class ItemBankController extends BaseController {
	@Autowired
	private ItemBankService itemBankService;

	/**
	 * @author: lvqingyang
	 * @Description: 添加题目
	 * @date: 2018年5月28日 下午6:55:30
	 */
	@Transactional
	@RequestMapping("/add")
	public String addItem(HttpServletRequest request, Map<String,Object> map) {
		String question = request.getParameter("question");
		String optionA = request.getParameter("optionA");
		String optionB = request.getParameter("optionB");
		String optionC = request.getParameter("optionC");
		String optionD = request.getParameter("optionD");
		String answer = request.getParameter("answer");
		User createUser = (User) request.getSession().getAttribute(DemoUtil.SESSION_USER);
		Date createDate = new Date();
		String[] item = {question, optionA, optionB, optionC, optionD, answer};
		itemBankService.addItem(item, createUser, createDate);
		//log
		map.put("backInfo", "题目已成功添加");
		return "item/add";
	}

	/**
	 * @author: lvqingyang
	 * @Description: 下载题目模板excel
	 * @date: 2018年5月29日 下午5:29:11
	 */
	@RequestMapping("/downloadExcel")
	public void downloadExcel(HttpServletResponse response){
		String filename = "题目上传模板.xlsx";
		try {
			filename = new String(filename.getBytes(),"UTF-8");
			XSSFWorkbook workbook = itemBankService.getExcel();
			OutputStream output=response.getOutputStream();
			response.reset();
			response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8")); 
			response.setContentType("application/vnd.ms-excel");  
			workbook.write(output);
			output.close();
		} catch (UnsupportedEncodingException e) {
			//log
		} catch (IOException e) {
			//log
		}
	}

	/**
	 * @author: lvqingyang
	 * @Description: 上传添加题库excel
	 * @date: 2018年5月29日 下午5:29:33
	 */
	@Transactional
	@RequestMapping("/uploadExcel")
	public String uploadExcel(@RequestParam(value="excel") MultipartFile file, HttpServletRequest request, Map<String,Object> map){
		Workbook workbook = getWorkbook(file);
		User createUser = (User) request.getSession().getAttribute(DemoUtil.SESSION_USER);
		Date createDate = new Date();
		boolean info = itemBankService.loadExcelDataAndSave(workbook, createUser, createDate);
		if(info == true){
			map.put("backInfo", "excel上传题库成功");
		} else {
			map.put("backInfo", "excel上传题库失败");
		}
		return "item/excel";
	}
	
	@RequestMapping("/goAdd")
	public String goAdd() {
		return "item/add";
	}
	
	@RequestMapping("/goExcel")
	public String goExcelanage() {
		return "item/excel";
	}
	
	@RequestMapping("/goManage")
	public String goManage() {
		return "item/manage";
	}
	
	@RequestMapping("/management")
	@ResponseBody
	public String manageItem() {
		List<ItemBank> itemList = itemBankService.listAllItems();
		return this.getJsonStr(itemList);
	}
	
	@RequestMapping("/search")
	@ResponseBody
	public String searchItem(@RequestParam(value="str") String str, HttpServletRequest request){
		List<ItemBank> itemList = itemBankService.searchItem(str);
		return this.getJsonStr(itemList);
	}
	
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Map<String,Object> map) {
		String itemId = request.getParameter("itemId");
		ItemBank item = itemBankService.findItemById(itemId);
		map.put("item", item);
		return "item/add";
	}
	
	@Transactional
	@RequestMapping("/update")
	public String updateItem(HttpServletRequest request) {
		String itemId = request.getParameter("itemId");
		String question = request.getParameter("question");
		String optionA = request.getParameter("optionA");
		String optionB = request.getParameter("optionB");
		String optionC = request.getParameter("optionC");
		String optionD = request.getParameter("optionD");
		String answer = request.getParameter("answer");
		String[] item = {question, optionA, optionB, optionC, optionD, answer};
		boolean result = itemBankService.update(itemId, item);
		if(result) {
			//log
		} else {
			//log
		}
		return "item/manage";
	}
	
	@Transactional
	@RequestMapping("/delete")
	public String deleteItem(HttpServletRequest request) {
		String itemId = request.getParameter("itemId");
		boolean result = itemBankService.delete(itemId);
		if(result) {
			//log
		} else {
			//log
		}
		return "item/manage";
	}

	public Workbook getWorkbook(MultipartFile file) {
		Workbook workbook = null;
		try {
			workbook = new HSSFWorkbook(file.getInputStream());
		} catch (Exception e) {
			//log
			try {
				workbook = new XSSFWorkbook(file.getInputStream());
			} catch (IOException e1) {
				//log
			}
		}
		return workbook;
	}
}
