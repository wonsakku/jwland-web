package com.jwland.domain.exam;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ExamWrongAnswerDeleteDto {

	@NotNull(message = "시험 기관을 선택해주세요")
	private int examTypeSequenceNo;
	@NotNull(message = "시험 과목을 선택해주세요")
	private String examSubjectCode;
	@NotNull
	private int accountSequenceNo;
	
}
