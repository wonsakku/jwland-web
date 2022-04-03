package com.jwland.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwland.dto.CommonCodeDto;
import com.jwland.web.service.CommonDataService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CommonDataController {

	
	private final CommonDataService commonDataService;
	
	
	@GetMapping("/schools")
	public ResponseEntity<List<CommonCodeDto>> getSchoolInfo(){
		List<CommonCodeDto> schoolInfo = commonDataService.getSchoolInfo();
		return ResponseEntity.status(HttpStatus.OK).body(schoolInfo);
	}
	
	@GetMapping("/grades")
	public ResponseEntity<List<CommonCodeDto>> getGradeInfo(){
		List<CommonCodeDto> gradeInfo = commonDataService.getGradeInfo();
		return ResponseEntity.status(HttpStatus.OK).body(gradeInfo);
	}
	
	
	
	@GetMapping("/exam-organization")
	public ResponseEntity<List<CommonCodeDto>> getExamOrganzations(){
		List<CommonCodeDto> examTypes = commonDataService.getExamOrganzations();
		return ResponseEntity.status(HttpStatus.OK).body(examTypes);
	}
	
	@GetMapping("/exam-subjects")
	public ResponseEntity<List<CommonCodeDto>> getExamSubjects(){
		List<CommonCodeDto> examSubjects = commonDataService.getExamSubjects();
		return ResponseEntity.status(HttpStatus.OK).body(examSubjects);
	}

}










