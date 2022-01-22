package com.jwland.web.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionMessages {

//	AUTHENTICATION_ERROR("로그인을 진행해주세요"),
	ALREADY_ENROLLED_ID("이미 등록된 ID입니다."),
	AUTHENTICATION_ERROR("로그인이 필요한 페이지입니다."),
	AUTHORIZE_ERROR("권한이 없습니다."),
	NO_ACCOUNT_ERROR("일치하는 계정 정보가 없습니다."),
	WRONG_ACCESS_ERROR("접근 방식이 올바르지 않습니다."),

	
	ALREADY_ENROLLED_EXAM("이미 등록된 기출입니다."),
	NO_MATCHED_EXAM("일치하는 시험 정보가 없습니다."),
	
	CLINIC_ENROLL_ERROR("'클리닉 / 보충' 등록 중 문제가 발생했습니다."), 
	CLINIC_APPLY_ERROR("'클리닉 / 보충' 신청 중 문제가 발생했습니다."), 
	CLINIC_CANCEL_ERROR("'클리닉 / 보충' 취소 중 문제가 발생했습니다.")
	;

	private String message;
	
}
