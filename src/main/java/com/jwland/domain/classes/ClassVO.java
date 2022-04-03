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
public class ClassVO {
	
	private Long classSequenceNo;
	private String className;
	private String classTypeCode;
	private String startDate;
	private String open;
	private LocalDateTime createdAt;
	private String createAccountId;
	private LocalDateTime modifyAt;
	private String modifyAccountId;
	
	public void assignCreateAndModifyAccountId(String id) {
		this.createAccountId = id;
		this.modifyAccountId = id;
	}

	
	public void assignModifyAccountId(String id) {
		this.modifyAccountId = id;
	}
	
}



































