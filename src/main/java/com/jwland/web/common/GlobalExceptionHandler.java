package com.jwland.web.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jwland.web.exception.NoAccountException;
import com.jwland.web.exception.WrongAccessException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoAccountException.class)
	public ModelAndView noAccountException(NoAccountException e, RedirectAttributes rttr) {
		log.error("--- Exception Message : {}", e.getMessage());
		rttr.addFlashAttribute("error", e.getMessage());
		return new ModelAndView("redirect:/login");
	}

	
	@ExceptionHandler(WrongAccessException.class)
	public ModelAndView wrongAccessException(WrongAccessException e, RedirectAttributes rttr) {
		log.error("--- Exception Message : {}", e.getMessage());
		rttr.addFlashAttribute("error", e.getMessage());
		return new ModelAndView("redirect:/");
	}


	@ExceptionHandler(BindException.class)
	public ModelAndView bindingException(HttpServletRequest request, BindException e, RedirectAttributes rttr) {
		log.error("--- Exception Message : {}", e.getMessage());
		
		String requestUri = request.getRequestURI().toString();
		
		if(e.hasFieldErrors()) {
			rttr.addFlashAttribute("error", e.getFieldErrors().get(0).getDefaultMessage());
			return new ModelAndView("redirect:" + requestUri);
		}
		
		if(e.hasGlobalErrors()) {
			rttr.addFlashAttribute("error", e.getGlobalErrors().get(0).getDefaultMessage());
			return new ModelAndView("redirect:" + requestUri);
		}
		
		return new ModelAndView("redirect:" + requestUri);
	}
	
	
}

























