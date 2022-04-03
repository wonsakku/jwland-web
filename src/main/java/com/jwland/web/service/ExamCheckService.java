package com.jwland.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwland.domain.exam.ExamWrongAnswerDto;
import com.jwland.domain.exam.ExamTotalInfoDto;
import com.jwland.domain.exam.ExamWrongAnswerDeleteDto;
import com.jwland.web.mapper.ExamCheckMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class ExamCheckService {

	private final ExamCheckMapper examCheckMapper;
	private final ModelMapper modelMapper;
	
	public List<ExamTotalInfoDto> getExamCheckList(String examSubjectCode, String accountSequenceNo) {
		
		Map<String, String> parameter = new HashMap<>();
		parameter.put("accountSequenceNo", accountSequenceNo);
		parameter.put("examSubjectCode", examSubjectCode);
		return examCheckMapper.getExamCheckList(parameter);
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
	public void enrollWrongAnswer(ExamWrongAnswerDto examWrongAnswerDto) {

		Map<String, Integer> parameter = getWrongAnswerParameter(examWrongAnswerDto);
		List<Integer> problemNumberList = examWrongAnswerDto.getProblemNumberList();
		
		for(Integer problemNumber : problemNumberList) {
			parameter.put("problemNumber", problemNumber);
			examCheckMapper.enrollWrongAnswer(parameter);
		}
		
	}

	public List<Integer> getWrongAsnwerExamYears(String accountSequenceNo) {
		return examCheckMapper.getWrongAsnwerExamYears(accountSequenceNo);
	}

	public List<Integer> getWrongAsnwerExamMonth(String accountSequenceNo, String year) {
		Map<String, String> parameter = new HashMap<>();
		parameter.put("accountSequenceNo", accountSequenceNo);
		parameter.put("year", year);
		
		return examCheckMapper.getWrongAsnwerExamMonth(parameter);
	}

	public List<Map> getWrongAsnwerExamTypes(String accountSequenceNo, String year, String month) {
		Map<String, String> parameter = new HashMap<>();
		parameter.put("accountSequenceNo", accountSequenceNo);
		parameter.put("year", year);
		parameter.put("month", month);
		return examCheckMapper.getWrongAsnwerExamTypes(parameter);
	}

	public List<Map> getWrongAsnwerSubjects(String accountSequenceNo, String examTypeSequenceNo) {
		Map<String, String> parameter = new HashMap<>();
		parameter.put("accountSequenceNo", accountSequenceNo);
		parameter.put("examTypeSequenceNo", examTypeSequenceNo);
		return examCheckMapper.getWrongAsnwerSubjects(parameter);
	}

	public List<Integer> getWrongAsnwerNumbers(String accountSequenceNo, String examTypeSequenceNo,
			String examSubjectSequenceNo) {
		Map<String, String> parameter = new HashMap<>();
		parameter.put("accountSequenceNo", accountSequenceNo);
		parameter.put("examTypeSequenceNo", examTypeSequenceNo);
		parameter.put("examSubjectSequenceNo", examSubjectSequenceNo);
		return examCheckMapper.getWrongAsnwerNumbers(parameter);
	}

	@Transactional
	public void updateWrongAnswerNumbers(ExamWrongAnswerDto examWrongAnswerDto) {
		deleteWrongAnswerNumbers(modelMapper.map(examWrongAnswerDto, ExamWrongAnswerDeleteDto.class));
		enrollWrongAnswer(examWrongAnswerDto);
	}	
	

	private Map<String, Integer> getWrongAnswerParameter(ExamWrongAnswerDto examWrongAnswerDto){

		Map<String, Integer> parameter = new HashMap<>();
		parameter.put("accountSequenceNo", examWrongAnswerDto.getAccountSequenceNo());
		parameter.put("examSubjectSequenceNo", examWrongAnswerDto.getExamSubjectSequenceNo());
		parameter.put("examTypeSequenceNo", examWrongAnswerDto.getExamTypeSequenceNo());
		
		return parameter;
	}

	@Transactional
	public void deleteWrongAnswerNumbers(ExamWrongAnswerDeleteDto examWrongAnswerDeleteDto) {
		examCheckMapper.deleteWrongAsnwerNumbers(examWrongAnswerDeleteDto);
	}

	public List<Map> getExamSubjects() {
		return examCheckMapper.getExamSubjects();
	}
	
}








