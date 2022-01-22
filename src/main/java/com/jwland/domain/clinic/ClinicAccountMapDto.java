package com.jwland.domain.clinic;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ClinicAccountMapDto {

	@NotNull
	private int accountSequenceNo;
	
	@NotNull
	private int clinicSequenceNo;
}
