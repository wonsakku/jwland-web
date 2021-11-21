package com.jwland.web.exception;

import com.jwland.web.common.ExceptionMessages;

public class WrongAccessException extends RuntimeException{

	public WrongAccessException() {
		super(ExceptionMessages.WRONG_ACCESS_ERROR.getMessage());
	}
}
