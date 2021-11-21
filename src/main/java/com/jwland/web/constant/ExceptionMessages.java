package com.jwland.web.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionMessages {

//	AUTHENTICATION_ERROR("로그인을 진행해주세요"),
	AUTHENTICATION_ERROR("로그인이 필요한 페이지입니다."),
	AUTHORIZE_ERROR("권한이 없습니다."),
	NO_ACCOUNT_ERROR("일치하는 계정 정보가 없습니다."),
	WRONG_ACCESS_ERROR("접근 방식이 올바르지 않습니다.")
	
	;

	private String message;
	
}
