/**
 * 
 */
package com.ie.util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author 
 * @Description: 
 * @date: 2018年5月26日 下午3:55:07 
 */
public class JacksonInstance {
	private static ObjectMapper mapper;   
	  
    public static synchronized ObjectMapper getMapperInstance(boolean createNew) {   
        if (createNew) {   
            return new ObjectMapper();   
        } else if (mapper == null) {   
            mapper = new ObjectMapper();   
        }   
        return mapper;   
    }  
}
