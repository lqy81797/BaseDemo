/**
 * 
 */
package com.ie.util;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author 
 * @Description: 该类的功能描述
 * @date: 2018年5月30日 下午7:17:01 
 */
public class BaseController {
	
	protected Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * @author: 
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
	 * 将查询出数据转换成json格式  
	 */
	public String getJsonStr(Page page, List list){
		ObjectMapper mapper = JacksonInstance.getMapperInstance(false);
		String rst = "";
		try {
			rst = mapper.writeValueAsString(list);//转换为JSON
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		int totalCount=page.getTotalResult();//所有记录数
		StringBuilder sb = new StringBuilder(); //修正格式符合grid要求的json格式
		sb.append("{\"Rows\":");
		sb.append(rst);
		sb.append(",\"Total\":");
		sb.append(totalCount+"}");//追加所有记录数到json
		rst = sb.toString();
		return rst;
	}
}
