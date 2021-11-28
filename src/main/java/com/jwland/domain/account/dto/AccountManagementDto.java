package com.jwland.domain.account.dto;

import lombok.Data;

@Data
public class AccountManagementDto {

	private Integer accountSequenceNo;
	private String name;
	private String birth;
	private String nickName;
	private String approved;
	private String role;
}
