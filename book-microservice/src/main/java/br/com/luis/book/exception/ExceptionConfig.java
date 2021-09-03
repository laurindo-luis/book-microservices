package br.com.luis.book.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import feign.FeignException;
import feign.RetryableException;

@RestControllerAdvice
public class ExceptionConfig {
	
	@ExceptionHandler({
		ObjectNotFoundException.class
	})
	public ResponseEntity<Void> noContent(Exception e) {
		return ResponseEntity.noContent().build();
	}
	
	@ExceptionHandler({
		RetryableException.class
	})
	public ResponseEntity<Void> notFound(Exception e) {
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler({
		IllegalArgumentException.class,
		FeignException.BadRequest.class
	})
	public ResponseEntity<?> badRequest(Exception e) {
		return ResponseEntity.badRequest().build();
	}
}
