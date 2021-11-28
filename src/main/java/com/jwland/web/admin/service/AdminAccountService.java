package com.jwland.web.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jwland.domain.account.dto.AccountManagementDto;
import com.jwland.web.admin.mapper.AdminAccountMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdminAccountService {

	private final AdminAccountMapper adminAccountMapper;

	public List<AccountManagementDto> getAccountManagementList(String name, String approved){
		
		Map<String, String> parameter = new HashMap<>();
		parameter.put("name", name);
		parameter.put("approved", approved);
		
		return adminAccountMapper.getAccountManagementList(parameter);
	}

	public void updateApproveStatus(List<Integer> accountSequenceList) {
		adminAccountMapper.updateApproveStatus(accountSequenceList);
	}
	
	
}









