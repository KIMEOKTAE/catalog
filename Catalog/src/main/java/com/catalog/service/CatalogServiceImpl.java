package com.catalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalog.mapper.CatalogMapper;
import com.catalog.vo.CatalogVO;

@Service
public class CatalogServiceImpl implements CatalogService{
	
	@Autowired
	CatalogMapper catalogMapper;

	@Override
	public List<CatalogVO> testQuery(CatalogVO param) {
		return catalogMapper.testQuery(param);
	}
}
