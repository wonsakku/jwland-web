package com.jwland.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;

@Slf4j
@RequiredArgsConstructor
@RestController
public class AttendanceController {

	
	
	@GetMapping("/attendance/page")
	public ModelAndView attendancePage() {
		return new ModelAndView("class/attendance");
	}
}
























