package com.jwland.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@RestController
public class IndexController {

	@GetMapping("/")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
}
















