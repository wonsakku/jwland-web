package com.jwland.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TestController {
	
	
	@GetMapping("/ajax/test-page")
	public ModelAndView ajaxPage() {
		return new ModelAndView("ajax-test");
	}
	
	@GetMapping("/ajax/test/{code}")
	public ResponseEntity<String> test(@PathVariable int code) {
		if(code == 1) {
			return ResponseEntity.status(HttpStatus.OK).body("SUUCESS_MESSAGE_BODY");
		}else if(code == 2) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("BAD_REQUEST_MESSAGE_BODY");
		}else if(code ==3) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("INTERNAL_SERVER_ERROR_MESSAGE_BODY");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("BAD_GATEWAY_MESSAGE_BODY");
		}
		
	}
}
