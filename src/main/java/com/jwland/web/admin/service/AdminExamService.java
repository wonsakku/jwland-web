package com.jwland.web.admin.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.jwland.domain.exam.ExamEnrollDto;
import com.jwland.web.admin.mapper.AdminExamMapper;
import com.jwland.web.constant.ExceptionMessages;
import com.jwland.web.exception.AlreadyEnrolledException;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class AdminExamService {

	private final AdminExamMapper adminExamMapper;
	
	public void enrollExam(ExamEnrollDto examEnrollDto) {
		Map<String, String> duplicateCheckMap = adminExamMapper.checkExamExist(examEnrollDto);
		
		if(duplicateCheckMap != null) {
			throw new AlreadyEnrolledException(ExceptionMessages.ALREADY_ENROLLED_EXAM);
		}
		
		adminExamMapper.enrollExam(examEnrollDto);
	}

}
