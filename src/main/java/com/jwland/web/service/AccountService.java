package com.jwland.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.jwland.domain.account.AccountVO;
import com.jwland.domain.account.dto.AccountInfoDto;
import com.jwland.domain.account.dto.FormLoginDto;
import com.jwland.domain.account.dto.JoinAccountDto;
import com.jwland.domain.account.dto.LoginSuccessDto;
import com.jwland.web.constant.ExceptionMessages;
import com.jwland.web.constant.VariableConstant;
import com.jwland.web.exception.AlreadyEnrolledException;
import com.jwland.web.exception.NoAccountException;
import com.jwland.web.mapper.AccountMapper;

import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Slf4j
@Service
//public class AccountService implements UserDetailsService{
public class AccountService{
	
	private final ModelMapper modelMapper;
	private final AccountMapper accountMapper;
	
	public void login(FormLoginDto formLoginDto, HttpServletRequest request) {

		// 계정 조회
		AccountVO loginAccount = accountMapper.login(formLoginDto).orElseThrow(NoAccountException::new);
		// 생일 일치 여부 확인
		if(!formLoginDto.getPassword().equals(loginAccount.getPassword())) {
			throw new NoAccountException();
		}
		
		HttpSession session = request.getSession();
		LoginSuccessDto loginInfo = LoginSuccessDto.builder()
				.accountSequenceNo(loginAccount.getAccountSequenceNo())
				.id(loginAccount.getId())
				.approved(loginAccount.getApproved())
				.role(loginAccount.getRole())
				.build();
		session.setAttribute(VariableConstant.LOGIN_ATTRIBUTE_NAME, loginInfo);
	}

	public void join(JoinAccountDto joinAccountDto) {
		
		if(accountMapper.idDuplicationCheck(joinAccountDto) != null) {
			throw new AlreadyEnrolledException(ExceptionMessages.ALREADY_ENROLLED_ID);
		}
		
		accountMapper.join(joinAccountDto);
	}

	public List<AccountInfoDto> findAccountsInfo(String name, String gradeSequenceNo) {
		Map<String, String> parameter = new HashMap<>();
		parameter.put("name", name);
		parameter.put("gradeSequenceNo", gradeSequenceNo);
		return accountMapper.findAccountsInfo(parameter) ;
	}

	public AccountVO getAccountDetail(long accountSequenceNo) {
		AccountVO account = accountMapper.getAccountDetail(accountSequenceNo);
		return account;
	}

	public void updateAccount(AccountVO accountVO) {
		String password = accountVO.getPassword();
		
		if(password != null || "".equals(password)) {
			// TODO 패스워드 인코딩
			
		}
		accountMapper.updateAccount(accountVO);
	}


//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		
//		System.out.println(1);
//		System.out.println(username);
//		
//		return null;
//	}
	
}







