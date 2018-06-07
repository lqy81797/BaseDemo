/**
 * 
 */
package com.ie.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lvqingyang
 * @Description: 该类的功能描述
 * @date: 2018年6月7日 下午1:58:32 
 */
@Controller
@RequestMapping(value="/AnalysisController")
public class AnalysisController {
	
	@RequestMapping("/goAnalysis")
	public String goAnalysis() {
		return "mark/analysis";
	}

}
