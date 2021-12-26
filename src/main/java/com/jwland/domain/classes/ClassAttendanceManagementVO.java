package com.jwland.domain.classes;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassAttendanceManagementVO {

	private int classSequenceNo;
	private int accountSequenceNo;
	private String status;
	private String classDate;
	private LocalDateTime createdAt;
	private String createAccountId;
	private LocalDateTime modifyAt;
	private String modifyAccountId;
	
	public void assignCreateAndModifyAccountId(String id) {
		this.createAccountId = id;
		this.modifyAccountId = id;
	}
	
}
