package com.jwland.domain.account.dto;

import lombok.Data;

@Data
public class AccountInfoDto {

	private Long accountSequenceNo;
	private String name;
	private String birth;
	private String nickName;
}
