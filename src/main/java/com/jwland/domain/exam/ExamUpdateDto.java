package com.jwland.domain.exam;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ExamUpdateDto {

	@NotNull
	private int examTypeSequenceNo;
	
	@NotNull
	private String examType;
}
