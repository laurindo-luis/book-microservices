package br.com.luis.book.currency_exchange;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Data
public class CurrencyExchangeDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String fromCurrency;
	private String toCurrency;
	private Double conversionFactor;
	private Double convertedValue;
	private String environment;
}
