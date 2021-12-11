package com.jwland.web.admin.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jwland.domain.exam.ExamEnrollDto;
import com.jwland.domain.exam.ExamUpdateDto;
import com.jwland.web.admin.service.AdminExamService;
import com.jwland.web.constant.VariableConstant;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/exam")
public class AdminExamController {

	private final AdminExamService adminExamService;
	
	@PostMapping("/enroll")
	public ResponseEntity<String> enrollExam(@RequestBody @Valid ExamEnrollDto examEnrollDto, Errors errors) {
		adminExamService.enrollExam(examEnrollDto);
		return ResponseEntity.status(HttpStatus.OK).body(VariableConstant.EXAM_ENROLL_SUCCESS_MESSAGE);
	}

	
	@GetMapping("/years")
	public ResponseEntity<List<Integer>> getExamYear(){
		List<Integer> years =  adminExamService.getExamYear();
		return ResponseEntity.status(HttpStatus.OK).body(years);
	}
	
	
	@GetMapping("/month")
	public ResponseEntity<List<Integer>> getExamMonth(@RequestParam(value = "year") String year){
		List<Integer> month = adminExamService.getExamMonth(year);
		return ResponseEntity.status(HttpStatus.OK).body(month);
	}
	
	
	@GetMapping("/types")
	public ResponseEntity<List<Map>> getExamTypes(@RequestParam(value = "year") String year,
			@RequestParam(value = "month") String month){
		List<Map> examTypes = adminExamService.getExamTypes(year, month);
		return ResponseEntity.status(HttpStatus.OK).body(examTypes);
	}
	
	@GetMapping("/organization")
	public ResponseEntity<List<Map>> getExamOrganzations(){
		List<Map> examTypes = adminExamService.getExamOrganzations();
		return ResponseEntity.status(HttpStatus.OK).body(examTypes);
	}
	
	
	@PutMapping
	public ResponseEntity<String> updateExamType(@RequestBody @Validated ExamUpdateDto examUpdateDto, Errors errors){
		adminExamService.updateExamType(examUpdateDto);
		return ResponseEntity.status(HttpStatus.OK).body(VariableConstant.EXAM_UPDATE_SUCCESS);
	}
	
	@DeleteMapping("/{examTypeSequenceNo}")
	public ResponseEntity<String> deleteExamType(@PathVariable int examTypeSequenceNo){
		adminExamService.deleteExamType(examTypeSequenceNo);
		return ResponseEntity.status(HttpStatus.OK).body(VariableConstant.EXAM_DELETE_SUCCESS);
	}
	
}



























