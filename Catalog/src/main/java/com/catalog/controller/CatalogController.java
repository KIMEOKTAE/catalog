package com.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.catalog.service.CatalogService;
import com.catalog.vo.CatalogVO;

@RestController
public class CatalogController {
 
	@Autowired
	CatalogService catalogService;

	@RequestMapping("/hello")
	public ModelAndView getListBoard() {
		CatalogVO param = new CatalogVO();
		ModelAndView mav = new ModelAndView();
		mav.addObject("model", catalogService.testQuery(param));
		return mav;
	}
	
	@RequestMapping("/testPage")
	public ModelAndView testPage(ModelAndView mav) {
		CatalogVO param = new CatalogVO();
		mav.setViewName("test");		
		List<CatalogVO> testModel = catalogService.testQuery(param);
		mav.addObject("model",testModel);
		System.out.println(testModel);
		System.out.println(mav.getViewName());
		return mav;
	}

}