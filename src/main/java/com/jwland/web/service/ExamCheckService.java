package com.jwland.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jwland.domain.exam.ExamTotalInfoDto;
import com.jwland.web.mapper.ExamCheckMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class ExamCheckService {

	private final ExamCheckMapper examCheckMapper;
	
	public List<ExamTotalInfoDto> getExamCheckList() {
		return examCheckMapper.getExamCheckList();
	}

}
