package com.jwland.web.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

import com.jwland.web.constant.UrlPathContant;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Component
public class AccessInterceptor implements HandlerInterceptor{

	private final AntPathMatcher antPathMatcher;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String requestUri = request.getRequestURI();
	
		boolean onlyAdmin = onlyAdmin(requestUri);
		boolean needAuthentication = needAuthentication(requestUri);
		
		if(onlyAdmin) {
			
		}

		if(needAuthentication) {
			
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	
	
	
	
	private boolean needAuthentication(String requestUri) {
		return UrlPathContant.studentAccessablePath().stream()
				.anyMatch(path -> antPathMatcher.match(path, requestUri));
	}

	private boolean onlyAdmin(String requestUri) {
		return UrlPathContant.onlyAdminAccessablePath().stream()
				.anyMatch(path -> antPathMatcher.match(path, requestUri));
	}
	
	
}
