package br.com.luis.book.currency_exchange;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
public interface CurrencyExchangeProxy {
	
	@GetMapping("/api/currency-exchange-service/{value}/{from}/{to}")
	public ResponseEntity<CurrencyExchangeDto> getCurrencyExchange(
			@PathVariable Double value, 
			@PathVariable String from, 
			@PathVariable String to);
	
}
