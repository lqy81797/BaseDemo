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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ie.entities.ItemBank;
import com.ie.entities.User;
import com.ie.service.ItemBankService;
import com.ie.util.BaseController;
import com.ie.util.DemoUtil;
import com.ie.util.Page;

/**
 * @author 
 * @Description: 题库Controller
 * @date: 2018年5月28日 下午6:04:21 
 */
@Controller
@RequestMapping("/ItemBankController")
public class ItemBankController extends BaseController {
	@Autowired
	private ItemBankService itemBankService;

	/**
	 * @author: 
	 * @Description: 添加题目
	 * @date: 2018年5月28日 下午6:55:30
	 */
	@Transactional
	@RequestMapping("/add")
	public String addItem(HttpServletRequest request, Map<String,Object> map) {
		try{
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
			map.put("backInfo", "题目已成功添加");
			logger.debug("成功添加题目");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "item/add";
	}

	/**
	 * @author: 
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
			logger.debug("成功下载题库模板");
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * @author: 
	 * @Description: 上传添加题库excel
	 * @date: 2018年5月29日 下午5:29:33
	 */
	@Transactional
	@RequestMapping("/uploadExcel")
	public String uploadExcel(@RequestParam(value="excel") MultipartFile file, HttpServletRequest request, Map<String,Object> map){
		try{
			Workbook workbook = getWorkbook(file);
			User createUser = (User) request.getSession().getAttribute(DemoUtil.SESSION_USER);
			Date createDate = new Date();
			boolean info = itemBankService.loadExcelDataAndSave(workbook, createUser, createDate);
			if(info == true){
				map.put("backInfo", "excel上传题库成功");
				logger.debug("excel上传题库成功");
			} else {
				map.put("backInfo", "excel上传题库失败");
				logger.debug("excel上传题库失败");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "item/excel";
	}

	@RequestMapping("/goAdd")
	public String goAdd() {
		logger.debug("进入新增题目页面");
		return "item/add";
	}

	@RequestMapping("/goExcel")
	public String goExcelanage() {
		logger.debug("进入excel导入页面");
		return "item/excel";
	}

	@RequestMapping("/goManage")
	public String goManage() {
		logger.debug("进入题库管理页面");
		return "item/manage";
	}

	@RequestMapping(value = "/management", method = {RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String manageItem(Page page) {
		try {
			List<ItemBank> itemList = itemBankService.listAllItems();
			//		itemList = formatDate(itemList);
			logger.debug("生成题库列表");
			return this.getJsonStr(page, itemList);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}

	}

	@RequestMapping("/search")
	@ResponseBody
	public String searchItem(@RequestParam(value="question") String question, HttpServletRequest request, Page page){
		try {
			List<ItemBank> itemList = itemBankService.searchItem(question);
			//		itemList = formatDate(itemList);
			return this.getJsonStr(page, itemList);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	//	public List<ItemBank> formatDate(List<ItemBank> itemBank) {
	//		for(ItemBank item : itemBank) {
	//			item.setTime(item.getCreateTime().toString());
	//		}
	//		return itemBank;
	//	}

//	@RequestMapping("/modify")
//	public String modify(HttpServletRequest request, Map<String,Object> map) {
//		String itemId = request.getParameter("itemId");
//		ItemBank item = itemBankService.findItemById(itemId);
//		map.put("item", item);
//		return "item/add";
//	}

	@Transactional
	@RequestMapping("/update")
	public String updateItem(HttpServletRequest request) {
		try {
			String itemId = request.getParameter("itemId");
			String question = request.getParameter("question");
			String optionA = request.getParameter("optionA");
			String optionB = request.getParameter("optionB");
			String optionC = request.getParameter("optionC");
			String optionD = request.getParameter("optionD");
			String answer = request.getParameter("answer");
			User createUser = (User) request.getSession().getAttribute(DemoUtil.SESSION_USER);
			Date createDate = new Date();
			String[] item = {question, optionA, optionB, optionC, optionD, answer};
			boolean result = itemBankService.update(itemId, item, createUser, createDate);
			if(result) {
				logger.debug("修改题库成功");
			} else {
				logger.debug("修改题库失败");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "item/manage";
	}

	@Transactional
	@RequestMapping("/delete")
	public String deleteItem(HttpServletRequest request) {
		try {
			String itemId = request.getParameter("itemId");
			boolean result = itemBankService.delete(itemId);
			if(result) {
				logger.debug("删除题目成功");
			} else {
				logger.debug("删除题目失败");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "item/manage";
	}

	public Workbook getWorkbook(MultipartFile file) {
		Workbook workbook = null;
		try {
			workbook = new XSSFWorkbook(file.getInputStream());
		} catch (Exception e) {
			logger.error(e.getMessage());
			try {
				workbook = new HSSFWorkbook(file.getInputStream());
			} catch (IOException e1) {
				logger.error(e.getMessage());
			}
		}
		return workbook;
	}
}
