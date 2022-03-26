package com.jwland.domain.classes.dto;

import lombok.Data;

@Data
public class ClassDetailDto {

	private int classSequenceNo;
	private String className;
	private int classTypeSequenceNo;
	private String startDate;
	private String open;
	private String modifyAccountId;
	private String modifyAt;
	
}
