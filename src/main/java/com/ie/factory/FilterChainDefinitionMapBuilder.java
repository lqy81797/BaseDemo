package com.ie.factory;
import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {

	public LinkedHashMap<String, String> buildFilterChainDefinitionMap(){
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("/login.jsp", "anon");
		map.put("/shiro/login", "anon");
		map.put("/register.jsp", "anon");
		map.put("/resource/**", "anon");
		map.put("/RegisterController/**", "anon");
		
		map.put("/**", "authc");
		
		return map;
	}
	
}
