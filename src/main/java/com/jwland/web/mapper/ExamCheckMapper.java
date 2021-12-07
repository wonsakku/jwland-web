package com.jwland.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jwland.domain.exam.ExamTotalInfoDto;

@Mapper
public interface ExamCheckMapper {

	public List<ExamTotalInfoDto> getExamCheckList(); 
}
