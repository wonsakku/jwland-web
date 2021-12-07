package com.jwland.domain.exam;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ExamEnrollDto {

	@NotNull
	@Min(value = 2010)
	@Max(value = 2100)
	private int year;
	
	@NotNull
	@Min(value = 1)
	@Max(value = 12)
	private int month;
	
	@NotNull
	private String examType;
}
