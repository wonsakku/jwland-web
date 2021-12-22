package com.jwland.domain.account;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
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
