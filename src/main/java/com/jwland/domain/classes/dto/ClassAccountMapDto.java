package com.jwland.domain.classes.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.jwland.web.constant.ExceptionMessages;
import com.jwland.web.constant.VariableConstant;

import lombok.Data;

@Data
public class ClassAccountMapDto {

	@NotNull(message = "올바르지 않은 접근방식입니다.")
	private Integer classSequenceNo;
	@NotNull(message = "선택된 학생이 없습니다.")
	private List<Integer> accountSequenceList;
}
