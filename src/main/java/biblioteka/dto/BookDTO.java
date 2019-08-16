package biblioteka.dto;

import lombok.Data;

@Data
public class BookDTO {

	private long bookId;

	private String author;

	private String title;

	private int publicingYear;
	private int retailValue;

	private String publicher;

	private long isbnNumber;

	private int numberOfPages;

	private String language;

	private String genre;

	private int vat = 20;
}
