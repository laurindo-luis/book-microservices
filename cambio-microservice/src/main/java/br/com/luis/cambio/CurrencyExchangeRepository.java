package br.com.luis.cambio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
	
	public CurrencyExchange findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);
}
