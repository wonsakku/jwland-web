package com.jwland.web.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jwland.domain.exam.ExamDuplicationValidateParameter;
import com.jwland.domain.exam.ExamEnrollDto;
import com.jwland.domain.exam.ExamUpdateDto;
import com.jwland.domain.school.SchoolVO;

@Mapper
public interface AdminSchoolMapper {
	
	List<SchoolVO> getSchoolList();
	
	int enrollSchool(SchoolVO schoolVO);
	
	int deleteSchool(int schoolSequenceNo);

	int updateSchool(SchoolVO schoolVO);

	Map<String, Long> getStudentCount(int schoolSequenceNo);
}
