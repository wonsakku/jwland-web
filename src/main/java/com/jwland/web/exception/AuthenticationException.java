package com.jwland.web.exception;

import com.jwland.web.common.ExceptionMessages;

public class AuthenticationException extends IllegalArgumentException{

	public AuthenticationException() {
		super(ExceptionMessages.AUTHENTICATION_ERROR.getMessage());
	}
}
