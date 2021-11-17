package com.jwland.domain.account;

import lombok.Data;

@Data
public class LoginSuccessDto {

	private Long accountSequenceNo;
	private String nickName;
	private String approved;
	private String role;
	
}
