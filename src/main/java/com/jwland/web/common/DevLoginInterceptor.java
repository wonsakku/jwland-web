package com.jwland.web.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.jwland.domain.account.AccountVO;
import com.jwland.domain.account.dto.FormLoginDto;
import com.jwland.domain.account.dto.LoginSuccessDto;
import com.jwland.web.constant.VariableConstant;
import com.jwland.web.exception.NoAccountException;
import com.jwland.web.mapper.AccountMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DevLoginInterceptor  implements HandlerInterceptor{

	private final AccountMapper accountMapper;
	private final Environment env;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		
		if(session.getAttribute(VariableConstant.LOGIN_ATTRIBUTE_NAME) != null) {
			return HandlerInterceptor.super.preHandle(request, response, handler);
		}
	
		String accountId = env.getProperty("login-id");
		String accountPassword = env.getProperty("login-password");
		
		FormLoginDto formLoginDto = FormLoginDto.builder()
				.name(accountId)
				.birth(accountPassword)
				.build();
	
		AccountVO loginAccount = accountMapper.login(formLoginDto).orElseThrow(NoAccountException::new);
		
		// 생일 일치 여부 확인
		if(!formLoginDto.getBirth().equals(loginAccount.getPassword())) {
			throw new NoAccountException();
		}
		
		LoginSuccessDto loginInfo = LoginSuccessDto.builder()
				.nickName(loginAccount.getId())
				.accountSequenceNo(loginAccount.getAccountSequenceNo())
				.approved(loginAccount.getApproved())
				.role(loginAccount.getRole())
				.build();
		session.setAttribute(VariableConstant.LOGIN_ATTRIBUTE_NAME, loginInfo);
	
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	

}
