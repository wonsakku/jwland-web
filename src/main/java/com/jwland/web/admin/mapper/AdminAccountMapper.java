package com.jwland.web.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jwland.domain.account.dto.AccountManagementDto;

@Mapper
public interface AdminAccountMapper {

	List<AccountManagementDto> getAccountManagementList(Map<String, String> parameter);
	void updateApproveStatus(List<Integer> accountSequenceList);

}
