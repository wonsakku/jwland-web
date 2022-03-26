package com.jwland.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jwland.domain.account.dto.AccountInfoDto;
import com.jwland.web.service.AccountService;
import com.jwland.web.service.CommonDataService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CommonDataController {

	
	private final CommonDataService commonDataService;
	
	
	@GetMapping("/schools")
	public ResponseEntity<List<Map>> getSchoolInfo(){
		List<Map> schoolInfo = commonDataService.getSchoolInfo();
		return ResponseEntity.status(HttpStatus.OK).body(schoolInfo);
	}
	
	@GetMapping("/grades")
	public ResponseEntity<List<Map>> getGradeInfo(){
		List<Map> gradeInfo = commonDataService.getGradeInfo();
		return ResponseEntity.status(HttpStatus.OK).body(gradeInfo);
	}
	
	
}










