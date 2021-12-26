package com.jwland.domain.account.dto;

import lombok.Data;

@Data
public class AccountManagementDto {

	private Integer accountSequenceNo;
	private String name;
	private String grade;
	private String schoolName;
	private String approved;
	private String role;
}
