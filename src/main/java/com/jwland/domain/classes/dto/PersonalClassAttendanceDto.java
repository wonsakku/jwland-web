package com.jwland.domain.classes.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PersonalClassAttendanceDto {

	@NotNull(message = "출석 상태가 선택되지 않은 학생이 있습니다.")
	private Integer attendanceStatusSequenceNo;
	
	@NotNull(message = "학생 정보가 정상적으로 전송되지 않았습니다.")
	private Integer accountSequenceNo;
}
