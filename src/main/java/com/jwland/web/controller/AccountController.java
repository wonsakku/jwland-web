package com.jwland.web.controller;

import java.util.Arrays;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jwland.domain.account.FormLoginDto;
import com.jwland.web.exception.WrongAccessException;
import com.jwland.web.service.AccountService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class AccountController {

	private final AccountService accountService;
	
	@GetMapping("/login")
	public ModelAndView loginPage(Model model) {
		ModelAndView mav = new ModelAndView("sign-in");
		
		mav.addObject("formLoginDto", new FormLoginDto());
		return mav;
	}
	
	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute(value = "formLoginDto") @Validated FormLoginDto formLoginDto,
			HttpServletRequest request) {
		
		accountService.login(formLoginDto, request);
		
		ModelAndView mav = new ModelAndView("redirect:/");
		return mav;
	}
	
	
	@PostMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		boolean login = Collections.list(session.getAttributeNames()).contains("accountSequenceNo");
		
		if(!login) {
			throw new WrongAccessException();
		}
		
		session.invalidate();
		
		return new ModelAndView("redirect:/");
	}
}
























