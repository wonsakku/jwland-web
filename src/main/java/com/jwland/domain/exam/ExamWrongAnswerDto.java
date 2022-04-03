package com.jwland.domain.exam;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ExamWrongAnswerDto {

	@NotNull
	private int accountSequenceNo;
	
	@NotNull(message = "시험 과목 선택은 필수입니다.")
	private String examSubjectCode;
	
	@NotNull(message = "시험 기관 선택은 필수입니다.")
	private int examTypeSequenceNo;
	
	@NotNull(message = "선택한 번호가 없습니다.")
	@Size(min = 1, max = 20, message = "문제번호를 1~20개 선택해야 합니다.")
	private List<Integer> problemNumberList;
	
}
