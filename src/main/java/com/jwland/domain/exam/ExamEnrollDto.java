package com.jwland.domain.exam;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ExamEnrollDto {

	@NotNull
	@Min(value = 1994, message = "시험 연도는 1994~2100 사이의 숫자를 입력해야 합니다.")
	@Max(value = 2100, message = "시험 연도는 1994~2100 사이의 숫자를 입력해야 합니다.")
	private int year;
	
	@NotNull
	@Min(value = 1, message = "월은 1~12 사이의 숫자를 입력해야 합니다.")
	@Max(value = 12,  message = "월은 1~12 사이의 숫자를 입력해야 합니다.")
	private int month;
	
	@NotNull
	private int examOrganizationSequenceNo;
}
