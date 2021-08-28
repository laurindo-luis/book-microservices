package br.com.luis.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luis.book.exception.ObjectNotFoundException;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public BookDto getBookById(Long id) {
		return bookRepository.findById(id)
				.map(BookDto::create)
				.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	}
}
