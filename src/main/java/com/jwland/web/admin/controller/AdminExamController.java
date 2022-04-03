package com.jwland.web.admin.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.servlet.ModelAndView;

import com.jwland.domain.exam.ExamEnrollDto;
import com.jwland.domain.exam.ExamUpdateDto;
import com.jwland.web.admin.service.AdminExamService;
import com.jwland.web.constant.CommonCode;
import com.jwland.web.constant.VariableConstant;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/exam")
public class AdminExamController {

	private final AdminExamService adminExamService;
	
	
	@GetMapping("/enroll-page")
	public ModelAndView enrollExamPage() {
		return new ModelAndView("admin/exam-enroll-page");
	}
	
	@GetMapping("/update-page")
	public ModelAndView updateExamPage() {
		return new ModelAndView("admin/exam-update-page");
	}
	
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
	
	@GetMapping("/excel-page")
	public ModelAndView excelPage() {
		return new ModelAndView("admin/exam-excel-page");
	}
	
	@GetMapping("/excel-download")
	public void examExcelDownload(@RequestParam(name = "start") String start,
			@RequestParam(name = "end", required = false, defaultValue = "") String end,
			@RequestParam(name="examSubjectCode", required = false, defaultValue = "") String examSubjectCode, 
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		Map<String, String> parameter = new HashMap<>();
		parameter.put("start", start);
		
		if(end == null || "".equals(end)) {
			end = new SimpleDateFormat("yyyy").format(new Date());
		}
		parameter.put("end", end);
		
		parameter.put("groupCode", CommonCode.EXAM_SUBJECT_CODE);
		
		if(examSubjectCode != null && !"".equals(examSubjectCode)) {
			parameter.put("examSubjectCode", examSubjectCode);
		}
		
		adminExamService.excelDownload(parameter, request, response);
	}
	
}



























