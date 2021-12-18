package com.jwland.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ClinicController {

	
	@GetMapping("/clinic/page")
	public ModelAndView clinicPage() {
		return new ModelAndView("clinic/clinic-page");
	}
}
