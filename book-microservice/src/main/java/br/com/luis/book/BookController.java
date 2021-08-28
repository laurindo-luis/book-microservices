package br.com.luis.book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book-service")
public class BookController {
		
	@Autowired
	private BookService bookService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/{id}/{currency}")
	public ResponseEntity<BookDto> getBookById(@PathVariable("id") Long id, 
			@PathVariable("currency") String currency) {
		
		String port = environment.getProperty("local.server.port");
		BookDto book = bookService.getBookById(id, currency);
		book.setEnvironment(port);
		
		return ResponseEntity.ok(book);
	}
}
