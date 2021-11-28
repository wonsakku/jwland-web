package com.jwland.domain.account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder @Data @NoArgsConstructor @AllArgsConstructor
public class LoginSuccessDto {

	private Long accountSequenceNo;
	private String nickName;
	private String approved;
	private String role;
}
