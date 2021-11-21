package com.jwland.web.exception;

import com.jwland.web.common.ExceptionMessages;

public class AuthorizeException extends RuntimeException{

	public AuthorizeException() {
		super(ExceptionMessages.AUTHORIZE_ERROR.getMessage());
	}
}
