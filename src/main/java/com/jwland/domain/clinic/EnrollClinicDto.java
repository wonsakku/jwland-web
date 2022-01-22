package com.jwland.domain.clinic;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EnrollClinicDto {

	
	@NotNull
	private String date;
	
	@NotNull
	private String hour;
	
	@NotNull
	private String minute;
	
	@NotNull
	private int clinicTypeSequenceNo;
	
	@NotNull
	private int classTypeSequenceNo;
}
