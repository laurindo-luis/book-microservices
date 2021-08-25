package br.com.luis.cambio;

import static java.util.Objects.isNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luis.exception.ObjectNotFoundException;

@Service
public class CurrencyExchangeService {
	
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
		
	public CurrencyExchangeDto findFromAndTo(String from, String to) {
		CurrencyExchange currency = currencyExchangeRepository.findByFromCurrencyAndToCurrency(from, to);
		
		if(isNull(currency)) {
			throw new ObjectNotFoundException("Object not found");
		}
		
		return CurrencyExchangeDto.create(currency);
	}
}
