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



























