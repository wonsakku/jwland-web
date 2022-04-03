package com.jwland.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jwland.dto.CommonCodeDto;
import com.jwland.web.constant.CommonCode;
import com.jwland.web.mapper.CommonDataMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommonDataService {

	private final CommonDataMapper commonDataMapper;
	
	public List<CommonCodeDto> getSchoolInfo() {
		return commonDataMapper.getCommonCode(CommonCode.SCHOOL_GROUP_CODE);
	}

	
	public List<CommonCodeDto> getGradeInfo() {
		return commonDataMapper.getCommonCode(CommonCode.GRADE_GROUP_CODE);
	}


	public List<CommonCodeDto> getExamOrganzations() {
		return commonDataMapper.getCommonCode(CommonCode.EXAM_ORGANIZATION_CODE);
	}


	public List<CommonCodeDto> getExamSubjects() {
		return commonDataMapper.getCommonCode(CommonCode.EXAM_SUBJECT_CODE);
	}

	
	
	
}
