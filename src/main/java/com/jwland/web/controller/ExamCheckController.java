package com.jwland.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jwland.domain.exam.EnrollWrongAnswerDto;
import com.jwland.domain.exam.ExamTotalInfoDto;
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
	public ResponseEntity<List<ExamTotalInfoDto>> examCheckList() {
		log.info("----- ExamCheckController.examCheckList() -----");
		List<ExamTotalInfoDto> examTotalInfoList = examCheckService.getExamCheckList();
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
	
	@GetMapping("/exam/organization")
	public ResponseEntity<List<Map>> getExamOrganzations(){
		List<Map> examTypes = examCheckService.getExamOrganzations();
		return ResponseEntity.status(HttpStatus.OK).body(examTypes);
	}
	
	@GetMapping("/exam/subjects/not-enrolled")
	public ResponseEntity<List<Map>> getNotEnrolledSubjects(@RequestParam(value = "examTypeSequenceNo") String examTypeSequenceNo,
			@RequestParam(value = "accountSequenceNo") String accountSequenceNo){
		
		List<Map> subjectList = examCheckService.getNotEnrolledSubjects(examTypeSequenceNo, accountSequenceNo);
		return ResponseEntity.status(HttpStatus.OK).body(subjectList);
	}

	@PostMapping("/exam")
	public ResponseEntity<String> enrollWrongAnswer(@RequestBody @Validated EnrollWrongAnswerDto enrollWrongAnswerDto){
		examCheckService.enrollWrongAnswer(enrollWrongAnswerDto);
		return ResponseEntity.status(HttpStatus.OK).body(VariableConstant.EXAM_ENROLL_WRONG_ANSWER_SUCCESS);
	}
	
	
}















