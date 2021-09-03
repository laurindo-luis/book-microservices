package br.com.luis.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionConfiguration {
	
	@ExceptionHandler({
		ObjectNotFoundException.class
	})
	public ResponseEntity<?> notContet(Exception e) {
		return ResponseEntity.noContent().build();
	}
	
	@ExceptionHandler({
		IllegalArgumentException.class
	})
	public ResponseEntity<?> badRequest(Exception e) {
		return ResponseEntity.badRequest().build();
	}
	
}
