package com.jwland.web.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.jwland.domain.account.AccountVO;
import com.jwland.domain.account.FormLoginDto;
import com.jwland.domain.account.LoginSuccessDto;
import com.jwland.web.exception.NoAccountException;
import com.jwland.web.mapper.AccountMapper;

import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Slf4j
@Service
public class AccountService {
	
	private final ModelMapper modelMapper;
	private final AccountMapper accountMapper;
	
	public void login(FormLoginDto formLoginDto, HttpServletRequest request) {

		// 계정 조회
		AccountVO loginAccount = accountMapper.login(formLoginDto).orElseThrow(NoAccountException::new);
		
		// 생일 일치 여부 확인
		if(!formLoginDto.getBirth().equals(loginAccount.getBirth())) {
			throw new NoAccountException();
		}
		
//		LoginSuccessDto account = modelMapper.map(loginAccount, LoginSuccessDto.class);
//		session.setAttribute("account", account);
		
		HttpSession session = request.getSession();
		session.setAttribute("accountSequenceNo", loginAccount.getAccountSequenceNo());
		session.setAttribute("role", loginAccount.getRole());
		session.setAttribute("approved", loginAccount.getApproved());
		session.setAttribute("nickName", loginAccount.getNickName());
	}
}







