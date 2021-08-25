package br.com.luis.cambio;

import java.io.Serializable;
import java.math.BigDecimal;

import org.modelmapper.ModelMapper;

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
	private BigDecimal conversionFactor;
	private BigDecimal convertedValue;
	private String environment;
	
	public static CurrencyExchangeDto create(CurrencyExchange currencyExchange) {
		return new ModelMapper().map(currencyExchange, CurrencyExchangeDto.class);
	}
	
	public BigDecimal calcCurrencyExchange(BigDecimal value) {
		return value.multiply(this.conversionFactor);
	}
}
