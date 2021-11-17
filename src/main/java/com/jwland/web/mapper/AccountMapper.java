package com.jwland.web.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.jwland.domain.account.AccountVO;
import com.jwland.domain.account.FormLoginDto;

@Mapper
public interface AccountMapper {

	public Optional<AccountVO> login(FormLoginDto formLoginDto);


}



