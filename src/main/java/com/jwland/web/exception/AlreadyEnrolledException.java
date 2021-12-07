package com.jwland.web.exception;

import com.jwland.web.constant.ExceptionMessages;

public class AlreadyEnrolledException extends IllegalArgumentException{

	public AlreadyEnrolledException(ExceptionMessages exceptionMessage) {
		super(exceptionMessage.getMessage());
	}
}
