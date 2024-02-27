package com.catalog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.catalog.vo.CatalogVO;

@Mapper
public interface CatalogMapper {
	List<CatalogVO> testQuery (CatalogVO param);
}
