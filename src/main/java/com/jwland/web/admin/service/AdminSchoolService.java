package com.jwland.web.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jwland.domain.school.SchoolVO;
import com.jwland.web.admin.mapper.AdminSchoolMapper;
import com.jwland.web.constant.VariableConstant;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminSchoolService {
	
	private final AdminSchoolMapper adminSchoolMapper;
	
	
	public List<SchoolVO> getSchoolList() {
		return adminSchoolMapper.getSchoolList();
	}


	public void enrollSchool(SchoolVO schoolVO) {
		adminSchoolMapper.enrollSchool(schoolVO);
	}


	public void updateSchool(SchoolVO schoolVO) {
		adminSchoolMapper.updateSchool(schoolVO);
	}


	public void deleteSchool(int schoolSequenceNo) {
		Map<String, Long> studentCount = adminSchoolMapper.getStudentCount(schoolSequenceNo);
		Long count = studentCount.get("count");
		int intCount = count.intValue();
		
		if(intCount > 0) {
			throw new RuntimeException(VariableConstant.SCHOOL_DELETE_FAIL);
		}
		
		adminSchoolMapper.deleteSchool(schoolSequenceNo);
	}

}









