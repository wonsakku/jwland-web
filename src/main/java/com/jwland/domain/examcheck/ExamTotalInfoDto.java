package com.jwland.domain.examcheck;

import lombok.Data;

@Data
public class ExamTotalInfoDto {

	private int year;
	private int month;
	private int grade;
	private String examType;
	private String subject;
	private int problemNumber;
	private int wrongCount;
}
