package com.jwland.examcheck;

import java.util.List;

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
	
	@GetMapping("/exam-check")
	public ModelAndView examCheckPage() {
		log.info("----- ExamCheckController.examCheckPage() -----");
		ModelAndView mav = new ModelAndView();
		List<ExamTotalInfoDto> examTotalInfoList = examCheckService.getExamCheckList();
		System.out.println(examTotalInfoList);
		mav.addObject("examTotalInfoList", examTotalInfoList);
		mav.setViewName("exam-check.html");
		return mav;
	}
	
}
