package com.gaoyuan.spring.dao;

import java.util.List;

import com.gaoyuan.spring.dto.ProductCollect;


public interface ProductCollectMapper {
	
	int insertList(List<ProductCollect> list);
}