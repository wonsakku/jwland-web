package com.jwland.web.exception;

import com.jwland.web.constant.ExceptionMessages;

public class AuthorizeException extends RuntimeException{

	public AuthorizeException() {
		super(ExceptionMessages.AUTHORIZE_ERROR.getMessage());
	}
}
