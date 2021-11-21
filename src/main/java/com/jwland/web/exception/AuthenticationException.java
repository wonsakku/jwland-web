package com.jwland.web.exception;

import com.jwland.web.constant.ExceptionMessages;

public class AuthenticationException extends IllegalArgumentException{

	public AuthenticationException() {
		super(ExceptionMessages.AUTHENTICATION_ERROR.getMessage());
	}
}
