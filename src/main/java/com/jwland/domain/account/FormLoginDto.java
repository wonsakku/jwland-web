package com.jwland.domain.account;

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
	@Size(min = 2, max = 20, message = "이름의 길이는 2~20자입니다.")
	private String name;

	@NotEmpty
	@Size(min = 4, max = 4, message = "생일은 4자리입니다.")
	private String birth;
}
