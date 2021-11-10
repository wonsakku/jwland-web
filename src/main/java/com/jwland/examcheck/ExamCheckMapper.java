package com.jwland.examcheck;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExamCheckMapper {

	public List<ExamTotalInfoDto> getExamCheckList(); 
}
