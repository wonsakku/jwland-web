package com.jwland.web.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/manage-page")
	public ModelAndView adminPage() {
		return new ModelAndView("admin/admin-page");
	}
	
	
	
	
}
