package com.jwland.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwland.domain.exam.EnrollWrongAnswerDto;
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

	public List<Integer> getExamYear() {
		return examCheckMapper.getExamYear();
	}

	public List<Integer> getExamMonth(String year) {
		return examCheckMapper.getExamMonth(year);
	}

	public List<Map> getExamTypes(String year, String month) {
		Map<String, String> parameter = new HashMap<>();
		parameter.put("year", year);
		parameter.put("month", month);
		List<Map> result = examCheckMapper.getExamTypes(parameter);
		System.out.println(result);
		return result;
	}

	public List<Map> getExamOrganzations() {
		return examCheckMapper.getExamOrganzations();
	}

	public List<Map> getNotEnrolledSubjects(String examTypeSequenceNo, String accountSequenceNo) {
		Map<String, String> parameter = new HashMap<>();
		parameter.put("examTypeSequenceNo", examTypeSequenceNo);
		parameter.put("accountSequenceNo", accountSequenceNo);
		return examCheckMapper.getNotEnrolledSubjects(parameter);
	}

	@Transactional
	public void enrollWrongAnswer(EnrollWrongAnswerDto enrollWrongAnswerDto) {
		
		int accountSequenceNo = enrollWrongAnswerDto.getAccountSequenceNo();
		int examSubjectSequenceNo = enrollWrongAnswerDto.getExamSubjectSequenceNo();
		int examTypeSequenceNo = enrollWrongAnswerDto.getExamTypeSequenceNo();
		List<Integer> problemNumberList = enrollWrongAnswerDto.getProblemNumberList();

		Map<String, Integer> parameter = new HashMap<>();
		parameter.put("accountSequenceNo", accountSequenceNo);
		parameter.put("examSubjectSequenceNo", examSubjectSequenceNo);
		parameter.put("examTypeSequenceNo", examTypeSequenceNo);
		
		for(Integer problemNumber : problemNumberList) {
			parameter.put("problemNumber", problemNumber);
			examCheckMapper.enrollWrongAnswer(parameter);
		}
		
	}	
	
}








