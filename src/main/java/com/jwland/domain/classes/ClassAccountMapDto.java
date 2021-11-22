package com.jwland.domain.classes;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ClassAccountMapDto {

	@NotNull
	private Integer classSequenceNo;
	@NotNull
	private List<Integer> accountSequenceList;
}
