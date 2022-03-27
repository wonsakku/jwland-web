package com.jwland.domain.account;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountVO {

	private Long accountSequenceNo;
	private String name;
	private String id;
	private String password;
	private int gradeSequenceNo;
	private int schoolSequenceNo;
	private String approved;
	private String role;
	private LocalDateTime createdAt;
	private LocalDateTime modifyAt;
	
}
