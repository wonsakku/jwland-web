package com.jwland.web.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jwland.web.constant.UrlPathConstant;
import com.jwland.web.constant.VariableConstant;
import com.jwland.web.exception.AlreadyEnrolledException;
import com.jwland.web.exception.AuthenticationException;
import com.jwland.web.exception.AuthorizeException;
import com.jwland.web.exception.NoAccountException;
import com.jwland.web.exception.WrongAccessException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoAccountException.class)
	public ResponseEntity<String> noAccountException(NoAccountException e) {
		log.error("--- Exception Message : {}", e.getMessage());
		return errorResponseEntity(HttpStatus.BAD_REQUEST, e.getMessage());
	}
 
	
	@ExceptionHandler(WrongAccessException.class)
	public ModelAndView wrongAccessException(WrongAccessException e, RedirectAttributes rttr) {
		log.error("--- Exception Message : {}", e.getMessage());
		rttr.addFlashAttribute(VariableConstant.ERROR, e.getMessage());
		return new ModelAndView(UrlPathConstant.REDIRECT_ROOT_PAGE);
	}
	
	@ExceptionHandler(AuthorizeException.class)
	public ModelAndView authorizeException(AuthorizeException e, RedirectAttributes rttr) {
		log.error("--- Exception Message : {}", e.getMessage());
		rttr.addFlashAttribute(VariableConstant.ERROR, e.getMessage());
		return new ModelAndView(UrlPathConstant.REDIRECT_ROOT_PAGE);
	}

	@ExceptionHandler(AuthenticationException.class)
	public ModelAndView authenticationException(AuthenticationException e, RedirectAttributes rttr) {
		log.error("--- Exception Message : {}", e.getMessage());
		rttr.addFlashAttribute(VariableConstant.ERROR, e.getMessage());
		return new ModelAndView(UrlPathConstant.REDIRECT_LOGIN_PAGE);
	}
	
	@ExceptionHandler(AlreadyEnrolledException.class)
	public ResponseEntity<String> alreayEnrolledException(AlreadyEnrolledException e){
		log.error("--- Exception Message : {}", e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<String> missingServletRequestParameterException(MissingServletRequestParameterException e){
		log.error("--- Exception Message ; {}", e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	

	@ExceptionHandler(BindException.class)
	public ResponseEntity<String> bindingException(HttpServletRequest request, BindException e, RedirectAttributes rttr) {
		log.error("--- Exception Message : {}", e.getMessage());
		
		String requestUri = request.getRequestURI().toString();
		
		if(e.hasFieldErrors()) {
			return errorResponseEntity(HttpStatus.BAD_REQUEST, e.getFieldError().getDefaultMessage());
		}
		if(e.hasGlobalErrors()) {
			return errorResponseEntity(HttpStatus.BAD_REQUEST,  e.getFieldError().getDefaultMessage());
		}
		return errorResponseEntity(HttpStatus.BAD_REQUEST,  e.getFieldError().getDefaultMessage());
	}

	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> runtimeException(RuntimeException e){
		return errorResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
	}
	
	private ResponseEntity<String> errorResponseEntity(HttpStatus status, String message){
		return ResponseEntity.status(status).body(message);
	}
	
}

























