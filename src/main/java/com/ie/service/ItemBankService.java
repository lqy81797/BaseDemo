package com.ie.service;

import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ie.entities.ItemBank;
import com.ie.entities.User;
import com.ie.repository.ItemBankRepository;

/**
 * @author 
 * @Description: 该类的功能描述
 * @date: 2018年5月28日 下午6:08:55 
 */
@Service
public class ItemBankService {
	@Autowired
	private ItemBankRepository itemBankDao;

	/**
	 * @author: 
	 * @Description: 向数据库添加新题目
	 * @date: 2018年5月28日 下午6:54:44
	 */
	public ItemBank addItem(String[] item, User createUser, Date createDate) throws Exception {
		ItemBank itemBank = new ItemBank();
		itemBank.setQuestion(item[0]);
		itemBank.setOptionA(item[1]);
		itemBank.setOptionB(item[2]);
		itemBank.setOptionC(item[3]);
		itemBank.setOptionD(item[4]);
		itemBank.setAnswer(item[5]);
		itemBank.setCreateUser(createUser.getUserName());
		itemBank.setCreateTime(createDate);
		return itemBankDao.save(itemBank);
	}

	/**
	 * @author: 
	 * @Description: 生成excel模板
	 * @date: 2018年5月30日 上午10:09:32
	 */
	public XSSFWorkbook getExcel() throws Exception {
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

	/**
	 * @author: 
	 * @Description: 读取excel数据并插入题库
	 * @date: 2018年5月30日 下午7:20:13
	 */
	public boolean loadExcelDataAndSave(Workbook workbook, User createUser, Date createDate) {
		try{
			for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
				Sheet sheet = workbook.getSheetAt(numSheet);
				if (sheet == null) {
					continue;
				}
				// 循环所有行
				for (int rowNum = 1; rowNum < sheet.getLastRowNum(); rowNum++) {
					Row row = sheet.getRow(rowNum);
					if (!(row.getCell(0).getStringCellValue().trim().equals("")) || row != null) {
						Cell question = row.getCell(0);
						Cell optionA = row.getCell(1);
						Cell optionB = row.getCell(2);
						Cell optionC = row.getCell(3);
						Cell optionD = row.getCell(4);
						Cell answer = row.getCell(5);

						ItemBank itemBank = new ItemBank();
						itemBank.setQuestion(question.getStringCellValue());
						itemBank.setOptionA(optionA.getStringCellValue());
						itemBank.setOptionB(optionB.getStringCellValue());
						itemBank.setOptionC(optionC.getStringCellValue());
						itemBank.setOptionD(optionD.getStringCellValue());
						itemBank.setAnswer(answer.getStringCellValue());
						itemBank.setCreateUser(createUser.getUserName());
						itemBank.setCreateTime(createDate);
						itemBankDao.save(itemBank);
					}
				}
			}
		return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * @author: 
	 * @Description: 列出题库中全部记录
	 * @date: 2018年5月30日 下午7:25:34
	 */
	public List<ItemBank> listAllItems() throws Exception {
		return itemBankDao.findAll();
	}
	
	public List<ItemBank> searchItem(String str) throws Exception {
		return itemBankDao.searchItem("%" + str + "%");
	}
	
	public ItemBank findItemById(String id) throws Exception {
		return itemBankDao.findOne(Integer.valueOf(id));
	}
	
	public boolean update(String id, String[] item, User createUser, Date createDate) throws Exception {
			ItemBank itemBank = new ItemBank();
			itemBank.setId(Integer.valueOf(id));
			itemBank.setQuestion(item[0]);
			itemBank.setOptionA(item[1]);
			itemBank.setOptionB(item[2]);
			itemBank.setOptionC(item[3]);
			itemBank.setOptionD(item[4]);
			itemBank.setAnswer(item[5]);
			itemBank.setCreateTime(createDate);
			itemBank.setCreateUser(createUser.getUserName());
			itemBankDao.save(itemBank);
			return true;
	}
	
	public boolean delete(String id) throws Exception {
			itemBankDao.delete(Integer.valueOf(id));
			return true;
	}
}
