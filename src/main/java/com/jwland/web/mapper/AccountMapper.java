package com.jwland.web.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.jwland.domain.account.AccountVO;
import com.jwland.domain.account.FormLoginDto;
import com.jwland.domain.account.JoinAccountDto;

@Mapper
public interface AccountMapper {

	public Optional<AccountVO> login(FormLoginDto formLoginDto);

	public void join(JoinAccountDto joinAccountDto);

	public AccountVO findByName(String name);



}



