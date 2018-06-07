package com.ie.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ie.util.BaseController;

/**
 * @author 
 * @Description: 统计分析
 * @date: 2018年6月7日 下午1:58:32 
 */
@Controller
@RequestMapping(value="/AnalysisController")
public class AnalysisController extends BaseController {
	
	@RequestMapping("/goAnalysis")
	public String goAnalysis() {
		logger.debug("进入统计分析页面");
		return "mark/analysis";
	}

}
