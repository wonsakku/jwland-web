package com.jwland.examcheck;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ExamCheckController {

	private final ExamCheckService examCheckService;
	
	@GetMapping("/exam-check/page")
	public ModelAndView examCheckPage() {
		log.info("----- ExamCheckController.examCheckPage() -----");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("exam-check.html");
		return mav;
	}
	
	@GetMapping("/exam-check")
	public ResponseEntity<List<ExamTotalInfoDto>> examCheckList() {
		log.info("----- ExamCheckController.examCheckList() -----");
		List<ExamTotalInfoDto> examTotalInfoList = examCheckService.getExamCheckList();
		return ResponseEntity.status(HttpStatus.OK).body(examTotalInfoList);
	}
	
}
