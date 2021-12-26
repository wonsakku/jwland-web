package com.jwland.domain.classes.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CreateClassDto {

	@NotNull(message = "수업명을 입력해주세요")
	private String className;

	@NotNull(message = "수업 분류를 선택해주세요")
	private int classTypeSequenceNo;
	
	@NotNull
	@Size(max = 6, min = 6, message = "수업 시작 연&월은 6자리로 입력해야 합니다.")
	private String startDate;
}
