package com.jwland.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jwland.web.mapper.CommonDataMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommonDataService {

	private final CommonDataMapper commonDataMapper;
	
	public List<Map> getSchoolInfo() {
		// TODO Auto-generated method stub
		return commonDataMapper.getSchoolInfo();
	}

	
	public List<Map> getGradeInfo() {
		return commonDataMapper.getGradeInfo();
	}

	
	
	
}
