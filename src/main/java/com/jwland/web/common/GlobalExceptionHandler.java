package com.jwland.web.common;

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


}












