package com.jwland.domain.exam;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ExamWrongAnswerDto {

	@NotNull
	private int accountSequenceNo;
	
	@NotNull
	private int examSubjectSequenceNo;
	
	@NotNull
	private int examTypeSequenceNo;
	
	@NotNull
	@Size(min = 1, max = 20, message = "문제번호를 1~20개 선택해야 합니다.")
	private List<Integer> problemNumberList;
	
}
