package com.jwland.web.admin.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jwland.domain.school.SchoolVO;
import com.jwland.web.admin.service.AdminSchoolService;
import com.jwland.web.constant.VariableConstant;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/schools")
public class AdminSchoolController {

	private final AdminSchoolService adminSchoolService;
	
	@GetMapping("/page")
	public ModelAndView adminSchoolPage() {
		return new ModelAndView("admin/school-manage-page");
	}
	
	
	@GetMapping
	public ResponseEntity<List<SchoolVO>> getSchoolList(){
		List<SchoolVO> schoolList = adminSchoolService.getSchoolList();
		log.info("schoolList={}", schoolList);
		return ResponseEntity.status(HttpStatus.OK).body(schoolList);
	}
	
	@PostMapping("/enroll")
	public ResponseEntity enrollSchool(@RequestBody SchoolVO schoolVO) {
		log.info("schoolVO={}", schoolVO);
		adminSchoolService.enrollSchool(schoolVO);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(VariableConstant.SCHOOL_CREATE_SUCCESS);
	}
	
	@PostMapping("/{schoolSequenceNo}/update")
	public ResponseEntity updateSchool(@PathVariable int schoolSequenceNo, @RequestBody SchoolVO schoolVO) {
		schoolVO.setSchoolSequenceNo(schoolSequenceNo);
		adminSchoolService.updateSchool(schoolVO);
		log.info("schoolVO={}", schoolVO);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(VariableConstant.SCHOOL_UPDATE_SUCCESS);
	}
	
	@PostMapping("/{schoolSequenceNo}/delete")
	public ResponseEntity deleteSchool(@PathVariable int schoolSequenceNo) {
		adminSchoolService.deleteSchool(schoolSequenceNo);
		return ResponseEntity.status(HttpStatus.OK).body(VariableConstant.SCHOOL_DELETE_SUCCESS);
	}
}













