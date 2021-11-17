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
	private String birth;
	private String nickName;
	private String approved;
	private String role;
	private LocalDateTime createdAt;
	private LocalDateTime modifyAt;
	
}
