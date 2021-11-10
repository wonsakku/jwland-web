package com.jwland.examcheck;

import java.util.List;

import org.springframework.stereotype.Service;

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
