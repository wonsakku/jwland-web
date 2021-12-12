package com.jwland.domain.exam;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ExamWrongAnswerDeleteDto {

	@NotNull
	private int examTypeSequenceNo;
	@NotNull
	private int examSubjectSequenceNo;
	@NotNull
	private int accountSequenceNo;
	
}
