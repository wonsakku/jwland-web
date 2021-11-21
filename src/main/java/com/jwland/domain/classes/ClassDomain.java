package com.jwland.domain.classes;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ClassDomain {
	
	private Long classSequenceNo;
	private String className;
	private String openYear;
	private String openMonth;
	private String startDate;
	private Integer totalClassCount;
	private Integer completeClassCount;
	private String open;
	private LocalDateTime createdAt;
	private String createAccountId;
	private LocalDateTime modifyAt;
	private String modifyAccountId;
	
	public void assignCreateAndModifyAccountId(String nickName) {
		this.createAccountId = nickName;
		this.modifyAccountId = nickName;
	}

	
	public void assignModifyAccountId(String nickName) {
		this.modifyAccountId = nickName;
	}
	
}



































