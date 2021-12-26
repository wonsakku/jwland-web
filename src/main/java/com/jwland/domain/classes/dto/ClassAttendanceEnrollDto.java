package com.jwland.domain.classes.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ClassAttendanceEnrollDto {

	@NotNull(message = "수업 정보가 정상적으로 넘어오지 않았습니다.")
	private Integer classSequenceNo;
	
	@NotNull(message = "수업 날짜가 정상적으로 넘어오지 않았습니다.")
	private String classDate;
	
	@Valid
	private List<PersonalClassAttendanceDto> attendanceInfo;
}
