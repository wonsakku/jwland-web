package com.jwland.web.admin.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwland.domain.exam.ExamEnrollDto;
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
	
}
