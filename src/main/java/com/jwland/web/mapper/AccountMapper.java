package com.jwland.web.mapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.jwland.domain.account.AccountVO;
import com.jwland.domain.account.dto.AccountInfoDto;
import com.jwland.domain.account.dto.FormLoginDto;
import com.jwland.domain.account.dto.JoinAccountDto;

@Mapper
public interface AccountMapper {

	public Optional<AccountVO> login(FormLoginDto formLoginDto);

	public void join(JoinAccountDto joinAccountDto);

	public AccountVO findByName(String name);

	public List<AccountInfoDto> findAccountsInfo(Map<String, String> paramater);

	public List<Map> getSchoolInfo();

	public List<Map> getGradeInfo();

	public Map idDuplicationCheck(JoinAccountDto joinAccountDto);

}



