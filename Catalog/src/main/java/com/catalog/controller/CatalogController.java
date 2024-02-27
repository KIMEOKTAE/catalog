package com.catalog.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.catalog.service.CatalogService;
import com.catalog.vo.CatalogVO;

@Controller
@RequestMapping("/")
public class CatalogController {
	
	@Autowired
	CatalogService catalogService;
	
	
	
	// DB연결 테스트
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		
		Map<String,Object> map = new HashMap<>();
		
		map.put("name", "김억태");
		map.put("data", LocalDateTime.now());
		
		mav.addObject("data", map);
		
		return mav;
	}
	
	// DB연결 테스트, jsonView 테스트
	@ResponseBody
	@RequestMapping("/hello.do")
	public ModelAndView getListBoard() {
		System.out.println("123123");
		CatalogVO param = new CatalogVO();
		ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("model", catalogService.testQuery(param));
		return mav;
	}

}