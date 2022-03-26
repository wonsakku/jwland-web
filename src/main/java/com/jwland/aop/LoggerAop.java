package com.jwland.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Aspect
public class LoggerAop {

	@Before("execution(* com.jwland..*Controller.*(..))")
	public void logBeforeController(JoinPoint joinPoint) {
		log.info("[log] {}", joinPoint.getSignature());
	}
	
}

