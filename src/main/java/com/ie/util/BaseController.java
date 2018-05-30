/**
 * 
 */
package com.ie.util;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author lvqingyang
 * @Description: 该类的功能描述
 * @date: 2018年5月30日 下午7:17:01 
 */
public class BaseController {
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
}
