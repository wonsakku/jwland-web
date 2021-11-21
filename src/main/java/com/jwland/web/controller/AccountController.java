package com.jwland.web.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jwland.domain.account.AccountInfoDto;
import com.jwland.domain.account.FormLoginDto;
import com.jwland.domain.account.JoinAccountDto;
import com.jwland.web.constant.UrlPathConstant;
import com.jwland.web.constant.VariableConstant;
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
		ModelAndView mav = new ModelAndView("account/sign-in");
		mav.addObject(VariableConstant.FORM_LOGIN_DTO, new FormLoginDto());
		return mav;
	}
	
	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute(value = VariableConstant.FORM_LOGIN_DTO) @Validated FormLoginDto formLoginDto,
			HttpServletRequest request) {
		
		accountService.login(formLoginDto, request);
		
		ModelAndView mav = new ModelAndView(UrlPathConstant.REDIRECT_ROOT_PAGE);
		return mav;
	}
	
	@GetMapping("/join")
	public ModelAndView joinPage() {
		ModelAndView mav = new ModelAndView("account/join");
		mav.addObject(VariableConstant.JOIN_ACCOUNT_DTO, new JoinAccountDto());
		return mav; 
	}
	
	
	@PostMapping("/join")
	public ModelAndView join(@ModelAttribute(value = VariableConstant.JOIN_ACCOUNT_DTO) @Validated JoinAccountDto joinAccountDto, 
			RedirectAttributes rttr,  Errors errors) {
		
		accountService.join(joinAccountDto);
		rttr.addFlashAttribute(VariableConstant.MESSAGE, joinAccountDto.getNickName() + VariableConstant.JOIN_SUCCESS_MESSAGE_SURFFIX);
		
		return new ModelAndView(UrlPathConstant.REDIRECT_LOGIN_PAGE);
	}
	
	
	@PostMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		boolean login = Collections.list(session.getAttributeNames()).contains(VariableConstant.LOGIN_ATTRIBUTE_NAME);
		
		if(!login) {
			throw new WrongAccessException();
		}
		
		session.invalidate();
		
		return new ModelAndView(UrlPathConstant.REDIRECT_ROOT_PAGE);
	}
	

	@GetMapping("/accounts")
	public ResponseEntity<List<AccountInfoDto>> findAccountsInfo(@RequestParam(value = "name", required = false, defaultValue = "") String name){
		List<AccountInfoDto> accountInfos = accountService.findAccountsInfo(name);
		return ResponseEntity.status(HttpStatus.OK).body(accountInfos);
	}

}
























