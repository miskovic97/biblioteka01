package biblioteka.service;

import java.util.List;
import java.util.Optional;

import biblioteka.model.Book;

public interface BookService {
	List<Book> getAll();

	Optional<Book> getBybookId(long bookId);

	List<Book> getByauthor(String author);

	List<Book> getBytitle(String title);

	List<Book> getBypublicingYear(int publichingYear);

	List<Book> getBypublicher(String publicher);

	List<Book> getByisbnNumber(long isbnNumber);

	List<Book> getBylanguage(String language);

	List<Book> getBygenre(String genre);

	List<Book> getBynumberOfPages(int numberOfPAges);

	Book save(Book book);

	Book update(Book book, long bookId);

	void delete(long bookId);
}
