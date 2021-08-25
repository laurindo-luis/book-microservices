package br.com.luis.cambio;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/currency-exchange-service")
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/{value}/{from}/{to}")
	public ResponseEntity<?> getCurrencyExchange(@PathVariable BigDecimal value, 
			@PathVariable String from, @PathVariable String to) {
		
		String port = environment.getProperty("local.server.port");
		
		CurrencyExchange currencyExchange = new CurrencyExchange(
				1L, "US", "BR", new BigDecimal(5.75), new BigDecimal(1000), port
		);
		
		return ResponseEntity.ok(currencyExchange);
	}
}
