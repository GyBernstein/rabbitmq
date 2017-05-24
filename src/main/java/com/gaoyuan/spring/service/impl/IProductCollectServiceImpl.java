package com.gaoyuan.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaoyuan.spring.dao.ProductCollectMapper;
import com.gaoyuan.spring.dto.ProductCollect;
import com.gaoyuan.spring.service.IProductCollectService;

@Service
public class IProductCollectServiceImpl implements IProductCollectService {

	@Autowired
	private ProductCollectMapper collectMapper;
	
	public int insertList(List<ProductCollect> list) {
		
		int i = collectMapper.insertList(list);
		return i;
	}

}
