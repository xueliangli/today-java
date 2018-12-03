package com.taotao.service.impl;

import com.taotao.mapper.TestMapper;
import com.taotao.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestServiceImpl implements TestService {
	@Resource
	private TestMapper mapper;
	@Override
	public String queryNow() {
		//1.注入mapper 
		//2.调用mapper的方法 返回
		return mapper.queryNow();
	}
}
