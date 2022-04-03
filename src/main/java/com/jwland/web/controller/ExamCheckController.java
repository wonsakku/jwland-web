package com.jwland.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jwland.domain.exam.ExamWrongAnswerDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jwland.domain.exam.ExamTotalInfoDto;
import com.jwland.domain.exam.ExamWrongAnswerDeleteDto;
import com.jwland.web.constant.VariableConstant;
import com.jwland.web.service.ExamCheckService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ExamCheckController {

	private final ExamCheckService examCheckService;
	
	@GetMapping("/exam-check/page")
	public ModelAndView examCheckPage(HttpServletRequest request) {
		log.info("----- ExamCheckController.examCheckPage() -----");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("exam-check");
		return mav;
	}
	
	@GetMapping("/exam-check")
	public ResponseEntity<List<ExamTotalInfoDto>> examCheckList(
			@RequestParam(value = "accountSequenceNo", required = false, defaultValue = "") String accountSequenceNo,
			@RequestParam(value = "examSubjectCode", required = false, defaultValue = "") String examSubjectCode) {
		
		List<ExamTotalInfoDto> examTotalInfoList = examCheckService.getExamCheckList(examSubjectCode, accountSequenceNo);
		log.info("examData`````{}", examTotalInfoList);
		return ResponseEntity.status(HttpStatus.OK).body(examTotalInfoList);
	}
	
	@GetMapping("/exam/years")
	public ResponseEntity<List<Integer>> getExamYear(){
		List<Integer> years =  examCheckService.getExamYear();
		return ResponseEntity.status(HttpStatus.OK).body(years);
	}
	
	
	@GetMapping("/exam/month")
	public ResponseEntity<List<Integer>> getExamMonth(@RequestParam(value = "year") String year){
		List<Integer> month = examCheckService.getExamMonth(year);
		return ResponseEntity.status(HttpStatus.OK).body(month);
	}
	
	
	@GetMapping("/exam/types")
	public ResponseEntity<List<Map>> getExamTypes(@RequestParam(value = "year") String year,
			@RequestParam(value = "month") String month){
		List<Map> examTypes = examCheckService.getExamTypes(year, month);
		return ResponseEntity.status(HttpStatus.OK).body(examTypes);
	}
	
	@GetMapping("/exam/subjects")
	public ResponseEntity<List<Map>> getExamSubjects(){
		List<Map> examSubjects = examCheckService.getExamSubjects();
		return ResponseEntity.status(HttpStatus.OK).body(examSubjects);
	}

	
	@GetMapping("/exam/subjects/not-enrolled")
	public ResponseEntity<List<Map>> getNotEnrolledSubjects(@RequestParam(value = "examTypeSequenceNo") String examTypeSequenceNo,
			@RequestParam(value = "accountSequenceNo") String accountSequenceNo){
		
		List<Map> subjectList = examCheckService.getNotEnrolledSubjects(examTypeSequenceNo, accountSequenceNo);
		return ResponseEntity.status(HttpStatus.OK).body(subjectList);
	}

	@PostMapping("/exam")
	public ResponseEntity<String> enrollWrongAnswer(@RequestBody @Validated ExamWrongAnswerDto enrollWrongAnswerDto){
		examCheckService.enrollWrongAnswer(enrollWrongAnswerDto);
		return ResponseEntity.status(HttpStatus.OK).body(VariableConstant.EXAM_ENROLL_WRONG_ANSWER_SUCCESS);
	}
	
	@GetMapping("/exam/wrong-answer/years")
	public ResponseEntity<List<Integer>> getWrongAsnwerExamYears(@RequestParam(value = "accountSequenceNo") String accountSequenceNo){
		List<Integer> wrongAsnwerExamYearList = examCheckService.getWrongAsnwerExamYears(accountSequenceNo);
		return ResponseEntity.status(HttpStatus.OK).body(wrongAsnwerExamYearList);
	}
	
	@GetMapping("/exam/wrong-answer/month")
	public ResponseEntity<List<Integer>> getWrongAsnwerExamMonth(@RequestParam(value = "accountSequenceNo") String accountSequenceNo,
			@RequestParam(value = "year") String year){
		List<Integer> wrongAsnwerExamMonthList = examCheckService.getWrongAsnwerExamMonth(accountSequenceNo, year);
		return ResponseEntity.status(HttpStatus.OK).body(wrongAsnwerExamMonthList);
	}
	
	@GetMapping("/exam/wrong-answer/types")
	public ResponseEntity<List<Map>> getWrongAsnwerExamTypes(@RequestParam(value = "accountSequenceNo") String accountSequenceNo,
			@RequestParam(value = "year") String year, @RequestParam(value = "month") String month){
		List<Map> wrongAsnwerExamMonthList = examCheckService.getWrongAsnwerExamTypes(accountSequenceNo, year, month);
		return ResponseEntity.status(HttpStatus.OK).body(wrongAsnwerExamMonthList);
	}
	
	@GetMapping("/exam/wrong-answer/subjects")
	public ResponseEntity<List<Map>> getWrongAsnwerSubjects(@RequestParam(value = "accountSequenceNo") String accountSequenceNo,
			@RequestParam(value = "examTypeSequenceNo") String examTypeSequenceNo){
		List<Map> wrongAsnwerExamMonthList = examCheckService.getWrongAsnwerSubjects(accountSequenceNo, examTypeSequenceNo);
		
		return ResponseEntity.status(HttpStatus.OK).body(wrongAsnwerExamMonthList);
	}
	
	
	
	@GetMapping("/exam/wrong-answer/exam-types/{examTypeSequenceNo}/subjects/{examSubjectSequenceNo}")
	public ResponseEntity<List<Integer>> getWrongAsnwerNumbers(@RequestParam(value = "accountSequenceNo") String accountSequenceNo,
			@PathVariable(value = "examTypeSequenceNo") String examTypeSequenceNo,
			@PathVariable(value = "examSubjectSequenceNo") String examSubjectSequenceNo){
		List<Integer> wrongAsnwerNumberList = examCheckService.getWrongAsnwerNumbers(accountSequenceNo, examTypeSequenceNo, examSubjectSequenceNo);
		return ResponseEntity.status(HttpStatus.OK).body(wrongAsnwerNumberList);
	}
	
	@PutMapping("/exam")
	public ResponseEntity<String> updateWrongAsnwerNumbers(@RequestBody @Validated ExamWrongAnswerDto examWrongAnswerDto){
		examCheckService.updateWrongAnswerNumbers(examWrongAnswerDto);
		return ResponseEntity.status(HttpStatus.OK).body(VariableConstant.EXAM_UPDATE_WRONG_ANSWER_SUCCESS);
	}
	
	@DeleteMapping("/exam")
	public ResponseEntity<String> updateWrongAsnwerNumbers(@RequestBody @Validated ExamWrongAnswerDeleteDto examWrongAnswerDeleteDto){
		examCheckService.deleteWrongAnswerNumbers(examWrongAnswerDeleteDto);
		return ResponseEntity.status(HttpStatus.OK).body(VariableConstant.EXAM_DELETE_WRONG_ANSWER_SUCCESS);
	}
	
	

	
	
}















