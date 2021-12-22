package com.jwland.domain.account.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class JoinAccountDto {

	@NotNull(message = "이름을 입력해주세요.")
	private String name;
	
	@NotNull(message = "아이디를 입력해주세요.")
	private String id;
	
	@NotNull
	@Length(min = 4, max = 200, message = "비밀번호를 10자리 이상이어야 합니다.")
	private String password;
	
	@NotNull(message = "학년를 선택해주세요")
	private int gradeSequenceNo;

	@NotNull(message = "학교를 선택해주세요")
	private int schoolSequenceNo;
	
}
