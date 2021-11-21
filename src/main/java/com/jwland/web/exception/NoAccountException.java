package com.jwland.web.exception;

import com.jwland.web.common.ExceptionMessages;

public class NoAccountException extends IllegalArgumentException{

	public NoAccountException() {
		super(ExceptionMessages.NO_ACCOUNT_ERROR.getMessage());
	}
}
