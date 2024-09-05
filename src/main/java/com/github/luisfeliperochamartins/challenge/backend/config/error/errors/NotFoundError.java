package com.github.luisfeliperochamartins.challenge.backend.config.error.errors;


public class NotFoundError extends RuntimeException {

	public NotFoundError(String msg) {
		super(msg);
	}
}
