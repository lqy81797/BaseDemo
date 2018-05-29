/**
 * 
 */
package com.ie.service;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ie.entities.ItemBank;
import com.ie.repository.ItemBankRepository;

/**
 * @author lvqingyang
 * @Description: 该类的功能描述
 * @date: 2018年5月28日 下午6:08:55 
 */
@Service
public class ItemBankService {
	@Autowired
	private ItemBankRepository itemBankDao;
	
	/**
	 * @author: lvqingyang
	 * @Description: 向数据库添加新题目
	 * @date: 2018年5月28日 下午6:54:44
	 */
	public void addItem(String[] item) {
		ItemBank itemBank = new ItemBank();
		itemBank.setQuestion(item[0]);
		itemBank.setOptionA(item[1]);
		itemBank.setOptionB(item[2]);
		itemBank.setOptionC(item[3]);
		itemBank.setOptionD(item[4]);
		itemBank.setAnswer(item[5]);
		itemBankDao.save(itemBank);
	}
	
	public XSSFWorkbook getExcel() {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell0 = row.createCell(0);
		XSSFCell cell1 = row.createCell(1);
		XSSFCell cell2 = row.createCell(2);
		XSSFCell cell3 = row.createCell(3);
		XSSFCell cell4 = row.createCell(4);
		XSSFCell cell5 = row.createCell(5);
		cell0.setCellValue("问题");
		cell1.setCellValue("选项A");
		cell2.setCellValue("选项B");
		cell3.setCellValue("选项C");
		cell4.setCellValue("选项D");
		cell5.setCellValue("答案");
		return workbook;
	}
}
