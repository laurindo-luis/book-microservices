package br.com.luis.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.luis.book.currency_exchange.CurrencyExchangeDto;
import br.com.luis.book.currency_exchange.CurrencyExchangeProxy;
import br.com.luis.book.exception.ObjectNotFoundException;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;
	
	public BookDto getBookById(Long id) {
		return bookRepository.findById(id)
				.map(BookDto::create)
				.orElseThrow(() -> new ObjectNotFoundException("Not found exception"));
	}
	
	public BookDto getBookById(Long id, String currency) {
		BookDto book = bookRepository.findById(id)
				.map(BookDto::create)
				.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
		book.setCurrency(currency);
		ResponseEntity<CurrencyExchangeDto> response = currencyExchangeProxy
				.getCurrencyExchange(book.getPrice(), "USD", currency);	
		CurrencyExchangeDto currencyExchangeDto = response.getBody();		
		book.setPrice(currencyExchangeDto.getConvertedValue());
		book.setEnvironment(currencyExchangeDto.getEnvironment());
		return book;
	}
}
