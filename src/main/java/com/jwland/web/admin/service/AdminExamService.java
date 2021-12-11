package com.jwland.web.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.jwland.domain.exam.ExamDuplicationValidateParameter;
import com.jwland.domain.exam.ExamEnrollDto;
import com.jwland.domain.exam.ExamUpdateDto;
import com.jwland.web.admin.mapper.AdminExamMapper;
import com.jwland.web.constant.ExceptionMessages;
import com.jwland.web.exception.AlreadyEnrolledException;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class AdminExamService {

	private final AdminExamMapper adminExamMapper;
	private final ModelMapper modelMapper;
	
	public void enrollExam(ExamEnrollDto examEnrollDto) {
		
		examDuplicationCheck( modelMapper.map(examEnrollDto, ExamDuplicationValidateParameter.class) );
		
		adminExamMapper.enrollExam(examEnrollDto);
	}

	public List<Integer> getExamYear() {
		return adminExamMapper.getExamYear();
	}

	public List<Integer> getExamMonth(String year) {
		return adminExamMapper.getExamMonth(year);
	}

	public List<Map> getExamTypes(String year, String month) {
		Map<String, String> parameter = new HashMap<>();
		parameter.put("year", year);
		parameter.put("month", month);
		return adminExamMapper.getExamTypes(parameter);
	}

	public List<Map> getExamOrganzations() {
		return adminExamMapper.getExamOrganzations();
	}

	public void updateExamType(ExamUpdateDto examUpdateDto) {
		examDuplicationCheck( modelMapper.map(examUpdateDto, ExamDuplicationValidateParameter.class) );
		adminExamMapper.updateExamType(examUpdateDto);
	}
	
	private void examDuplicationCheck(ExamDuplicationValidateParameter parameter) {
		
		Map<String, String> duplicateCheckMap = adminExamMapper.checkExamExist(parameter);
		
		if(duplicateCheckMap != null) {
			throw new AlreadyEnrolledException(ExceptionMessages.ALREADY_ENROLLED_EXAM);
		}
	}

	public void deleteExamType(int examTypeSequenceNo) {
		int deleteCount = adminExamMapper.deleteExamType(examTypeSequenceNo);
		if(deleteCount < 1) {
			throw new IllegalArgumentException(ExceptionMessages.NO_MATCHED_EXAM.getMessage());
		}
	}


}
