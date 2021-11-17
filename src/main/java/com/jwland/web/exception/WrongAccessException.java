package com.jwland.web.exception;

public class WrongAccessException extends RuntimeException{

	public WrongAccessException() {
		super("잘못된 접근 방식입니다.");
	}
}
