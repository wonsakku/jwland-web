package com.jwland.web.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

import com.jwland.domain.account.dto.LoginSuccessDto;
import com.jwland.web.constant.UrlPathConstant;
import com.jwland.web.constant.VariableConstant;
import com.jwland.web.exception.AuthenticationException;
import com.jwland.web.exception.AuthorizeException;

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
			return canAccessAsAdmin(request, response);
		}

		if(needAuthentication) {
			
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	
	private boolean canAccessAsAdmin(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		LoginSuccessDto loginInfo = (LoginSuccessDto) session.getAttribute(VariableConstant.LOGIN_ATTRIBUTE_NAME);

		if(loginInfo == null) {
			throw new AuthenticationException();
		}
		
		if(!VariableConstant.ADMIN.equals(loginInfo.getRole())) {
			throw new AuthorizeException();
		}
		
		return true;
	}





	private boolean needAuthentication(String requestUri) {
		return UrlPathConstant.studentAccessablePath().stream()
				.anyMatch(path -> antPathMatcher.match(path, requestUri));
	}

	private boolean onlyAdmin(String requestUri) {
		return UrlPathConstant.onlyAdminAccessablePath().stream()
				.anyMatch(path -> antPathMatcher.match(path, requestUri));
	}
	
	
}
