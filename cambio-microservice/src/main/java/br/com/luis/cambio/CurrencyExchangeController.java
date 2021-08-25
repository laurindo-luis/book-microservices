package br.com.luis.cambio;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
	Environment environment;
	
	@Autowired
	private CurrencyExchangeService currencyExchangeService;
	
	@GetMapping("/{value}/{from}/{to}")
	public ResponseEntity<CurrencyExchangeDto> getCurrencyExchange(@PathVariable BigDecimal value, 
			@PathVariable String from, @PathVariable String to) {
		
		String port = environment.getProperty("local.server.port");
		
		CurrencyExchangeDto currencyExchangeDto = currencyExchangeService.findFromAndTo(from, to);
		BigDecimal convertedValue = currencyExchangeDto.calcCurrencyExchange(value);
		currencyExchangeDto.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));
		currencyExchangeDto.setEnvironment(port);
		
		return ResponseEntity.ok(currencyExchangeDto);
	}
}
