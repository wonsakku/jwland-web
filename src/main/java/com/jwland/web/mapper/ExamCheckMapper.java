package com.jwland.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jwland.domain.exam.ExamTotalInfoDto;

@Mapper
public interface ExamCheckMapper {

	public List<ExamTotalInfoDto> getExamCheckList(); 
	
	List<Integer> getExamYear();

	List<Integer> getExamMonth(String year);

	List<Map> getExamTypes(Map<String, String> parameter);

	List<Map> getExamOrganzations();

	public List<Map> getNotEnrolledSubjects(Map<String, String> parameter);

	public void enrollWrongAnswer(Map<String, Integer> parameter);
}
