package com.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.catalog.service.CatalogService;
import com.catalog.vo.CatalogVO;

@RestController
public class CatalogController {
 
	@Autowired
	CatalogService catalogService;
	
	@ResponseBody
	@RequestMapping("/hello.do")
	public ModelAndView getListBoard() {
		System.out.println("123123");
		CatalogVO param = new CatalogVO();
		ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("model", catalogService.testQuery(param));
		return mav;
	}
	
	
	@RequestMapping("/testPage")
	public ModelAndView testPage() {
		ModelAndView mav = new ModelAndView("test");
		
		CatalogVO param = new CatalogVO();
		
		List<CatalogVO> testModel = catalogService.testQuery(param);
		
		System.out.println(testModel);
		
		return mav;
	}

}