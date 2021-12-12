package com.jwland.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jwland.domain.exam.ExamTotalInfoDto;
import com.jwland.domain.exam.ExamWrongAnswerDeleteDto;

@Mapper
public interface ExamCheckMapper {

	public List<ExamTotalInfoDto> getExamCheckList();
	
	public List<ExamTotalInfoDto> getMyWrongAnswers(Map<String, String> parameter);
	
	List<Integer> getExamYear();

	List<Integer> getExamMonth(String year);

	List<Map> getExamTypes(Map<String, String> parameter);

	List<Map> getExamOrganzations();

	public List<Map> getNotEnrolledSubjects(Map<String, String> parameter);

	public void enrollWrongAnswer(Map<String, Integer> parameter);

	public List<Integer> getWrongAsnwerExamYears(String accountSequenceNo);

	public List<Integer> getWrongAsnwerExamMonth(Map<String, String> parameter);

	public List<Map> getWrongAsnwerExamTypes(Map<String, String> parameter);

	public List<Map> getWrongAsnwerSubjects(Map<String, String> parameter);

	public List<Integer> getWrongAsnwerNumbers(Map<String, String> parameter);

	public void deleteWrongAsnwerNumbers(ExamWrongAnswerDeleteDto examWrongAnswerDeleteDto);
}
