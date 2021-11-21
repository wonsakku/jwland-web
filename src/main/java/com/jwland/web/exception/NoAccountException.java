package com.jwland.web.exception;

import com.jwland.web.constant.ExceptionMessages;

public class NoAccountException extends IllegalArgumentException{

	public NoAccountException() {
		super(ExceptionMessages.NO_ACCOUNT_ERROR.getMessage());
	}
}
