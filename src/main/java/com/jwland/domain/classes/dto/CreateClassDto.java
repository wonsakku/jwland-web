package com.jwland.domain.classes.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CreateClassDto {

	@NotNull
	private String className;
	
	@NotNull
	@Size(max = 4, min = 4, message = "수업 시작 연도는 4자리로 입력해야 합니다.")
	private String openYear;
	@NotNull
	@Size(max = 2, min = 2, message = "수업 시작 월은 2자리로 입력해야 합니다.")
	private String openMonth;
	@NotNull
	@Size(max = 8, min = 8, message = "개강 날짜는 8자리로 입력해야 합니다.")
	private String startDate;
	@NotNull
	private Integer totalClassCount;

}
