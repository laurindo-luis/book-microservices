package br.com.luis.book;

import java.io.Serializable;
import java.util.Date;

import org.modelmapper.ModelMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Data
public class BookDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String author;
	private String title;
	private Double price;
	private Date launchDate;
	private String currency;
	private String environment;
	
	public static BookDto create(Book book) {
		return new ModelMapper().map(book, BookDto.class);
	}
}
