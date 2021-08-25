package br.com.luis.cambio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {
	
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
		
	public CurrencyExchangeDto findFromAndTo(String from, String to) {
		CurrencyExchange currency = currencyExchangeRepository.findByFromCurrencyAndToCurrency(from, to);
		return CurrencyExchangeDto.create(currency);
	}
}
