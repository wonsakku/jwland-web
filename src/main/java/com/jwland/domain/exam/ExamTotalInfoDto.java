package com.jwland.domain.exam;

import lombok.Data;

@Data
public class ExamTotalInfoDto {

	private int year;
	private int month;
	private String examType;
	private String subject;
	private int problemNumber;
	private int wrongCount;
}
