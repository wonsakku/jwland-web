package com.jwland.domain.account;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class JoinAccountDto {

	@NotNull(message = "이름을 입력해주세요.")
	private String name;
	
	@NotNull
	@Size(max = 4, min = 4, message = "생일은 4자리여야 합니다.")
	private String birth;
	
	@NotNull
	@Size(max = 20, min = 2, message = "닉네임은 2~20자리여야 합니다.")
	private String nickName;

}
