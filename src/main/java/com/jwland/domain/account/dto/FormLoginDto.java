package com.jwland.domain.account.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FormLoginDto {

	@NotEmpty
	@Size(min = 2, max = 20, message = "ID는 2~20자입니다.")
	private String id;

	@NotEmpty
	@Size(min = 4, max = 20, message = "Password는 4자리입니다.")
	private String password;
}
