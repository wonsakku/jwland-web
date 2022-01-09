package com.jwland.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jwland.web.service.ClinicService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ClinicController {

	private final ClinicService clinicService;
	
	@GetMapping("/clinic/page")
	public ModelAndView clinicPage() {
		return new ModelAndView("clinic/clinic-page");
	}
	
	@GetMapping("/clinic")
	public ResponseEntity<List<Map>> loadClinicData(@RequestParam(value = "date", required = true) String date,
			@RequestParam(value = "accountSequenceNo", required = true) String accountSequenceNo){
		List<Map> clinicList = clinicService.loadClinicData(date, accountSequenceNo);
		return ResponseEntity.status(HttpStatus.OK).body(clinicList);
	}
	
	@GetMapping("/clinic/list")
	public ResponseEntity<List<Map>> loadClinicList(@RequestParam(value = "startDate", required = true) String startDate,
			@RequestParam(value = "endDate", required = true) String endDate){
		List<Map> clinicList = clinicService.loadClinicList(startDate, endDate);
		return ResponseEntity.status(HttpStatus.OK).body(clinicList);
	}
}
