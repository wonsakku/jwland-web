package com.jwland.domain.account;

import lombok.Data;

@Data
public class AccountInfoDto {

	private Long accountSequenceNo;
	private String name;
	private String birth;
	private String nickName;
}
