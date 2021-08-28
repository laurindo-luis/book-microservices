package br.com.luis.book.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionConfig {
	
	@ExceptionHandler({
		ObjectNotFoundException.class
	})
	public ResponseEntity<?> noContent(Exception e) {
		return ResponseEntity.noContent().build();
	}
}
