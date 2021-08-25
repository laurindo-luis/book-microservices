package br.com.luis.cambio;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Data
@Entity
public class CurrencyExchange implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String fromCurrency;
	private String toCurrency;
	private BigDecimal conversionFactor;
	private BigDecimal convertedValue;
	private String environment;
}
