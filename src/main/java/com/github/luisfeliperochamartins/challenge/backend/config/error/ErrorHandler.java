package com.github.luisfeliperochamartins.challenge.backend.config.error;

import com.github.luisfeliperochamartins.challenge.backend.config.error.errors.NotFoundError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(NotFoundError.class)
	public ResponseEntity<Void> notFound(NotFoundError err) {
		return ResponseEntity.notFound().build();
	}
}
