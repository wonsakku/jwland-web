package com.jwland.web.exception;

import com.jwland.web.constant.ExceptionMessages;

public class WrongAccessException extends RuntimeException{

	public WrongAccessException() {
		super(ExceptionMessages.WRONG_ACCESS_ERROR.getMessage());
	}
}
