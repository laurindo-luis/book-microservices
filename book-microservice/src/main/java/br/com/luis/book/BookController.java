package br.com.luis.book;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/api/book-service")
public class BookController {
		
	@Autowired
	private BookService bookService;
	
	@Autowired
	private Environment environment;
	
	private Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@GetMapping("/{id}")
	public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
		BookDto book = bookService.getBookById(id);
		return ResponseEntity.ok(book);
	}
	
	@GetMapping("/{id}/{currency}")
	public ResponseEntity<BookDto> getBookById(@PathVariable("id") Long id, 
			@PathVariable("currency") String currency) {
		
		String port = environment.getProperty("local.server.port");
		BookDto book = bookService.getBookById(id, currency);
		
		book.setEnvironment(String.format("Port cambio-service: %s - Port book-service: %s",
			book.getEnvironment(), port));
		
		return ResponseEntity.ok(book);
	}
	
	@GetMapping("/resilience4j")
	@Retry(name = "default", fallbackMethod = "fallbackMethod")
	public String getTestResilience4j() {
		logger.info("Request book-service is received!");
		return new RestTemplate().getForEntity("http://localhost:8080/book-service", String.class).getBody();
	}
	
	public String fallbackMethod(Exception e) {
		return "fallbackMethod!!!";
	}
}
