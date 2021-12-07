package com.jwland.web.admin.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jwland.domain.exam.ExamEnrollDto;

@Mapper
public interface AdminExamMapper {

	void enrollExam(ExamEnrollDto examEnrollDto);

	Map<String, String> checkExamExist(ExamEnrollDto examEnrollDto);
}
