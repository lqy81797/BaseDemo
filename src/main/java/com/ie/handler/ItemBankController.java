/**
 * 
 */
package com.ie.handler;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ie.service.ItemBankService;

/**
 * @author lvqingyang
 * @Description: 题库Controller
 * @date: 2018年5月28日 下午6:04:21 
 */
@Controller
@RequestMapping("/ItemBankController")
public class ItemBankController {
	@Autowired
	private ItemBankService itemBankService;

	/**
	 * @author: lvqingyang
	 * @Description: 添加题目
	 * @date: 2018年5月28日 下午6:55:30
	 */
	@RequestMapping("/add")
	public String addItem(HttpServletRequest request, Map<String,Object> map) {
		String question = request.getParameter("question");
		String optionA = request.getParameter("optionA");
		String optionB = request.getParameter("optionB");
		String optionC = request.getParameter("optionC");
		String optionD = request.getParameter("optionD");
		String answer = request.getParameter("answer");
		String[] item = {question, optionA, optionB, optionC, optionD, answer};
		itemBankService.addItem(item);
		map.put("backInfo", "题目已成功添加");
		return "item/add";
	}

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

	@RequestMapping("/uploadExcel")
	public String uploadExcel(@RequestParam(value="excel") MultipartFile file){
		return null;
	}
}
