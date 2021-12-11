package com.jwland.web.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jwland.domain.exam.ExamDuplicationValidateParameter;
import com.jwland.domain.exam.ExamEnrollDto;
import com.jwland.domain.exam.ExamUpdateDto;

@Mapper
public interface AdminExamMapper {

	void enrollExam(ExamEnrollDto examEnrollDto);

	Map<String, String> checkExamExist(ExamDuplicationValidateParameter examEnrollDto);

	List<Integer> getExamYear();

	List<Integer> getExamMonth(String year);

	List<Map> getExamTypes(Map<String, String> parameter);

	List<Map> getExamOrganzations();

	void updateExamType(ExamUpdateDto examUpdateDto);

	int deleteExamType(int examTypeSequenceNo);
}
