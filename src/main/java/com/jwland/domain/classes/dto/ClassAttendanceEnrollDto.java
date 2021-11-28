package com.jwland.domain.classes.dto;

import java.util.List;

import lombok.Data;

@Data
public class ClassAttendanceEnrollDto {

	private Integer classSequenceNo;
	private String className;
	private String classDate;
	private List<PersonalClassAttendanceDto> attendanceInfo;
}
