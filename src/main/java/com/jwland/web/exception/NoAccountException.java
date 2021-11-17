package com.jwland.web.exception;

public class NoAccountException extends IllegalArgumentException{

	public NoAccountException() {
		super("일치하는 계정 정보가 없습니다.");
	}
}
