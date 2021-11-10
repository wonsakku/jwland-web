package com.jwland.examcheck;

import lombok.Data;

@Data
public class ExamTotalInfoDto {

	private int year;
	private int month;
	private String title;
	private int wrongAnswerCount;
}
