package biblioteka.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteka.model.Book;
import biblioteka.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookRepository bookrepository;
	@Override
	public List<Book> getAll() {
		
		return bookrepository.findAll();
	}

	@Override
	public Optional<Book> getByBookId(long bookId) {
		return bookrepository.findByBookId(bookId);}

	@Override
	public List<Book> getByauthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getBytitle(String title) {
		return bookrepository.findByTitle(title);
	}

	@Override
	public List<Book> getBypublicingYear(int publichingYear) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getBypublicher(String publicher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getByisbnNumber(long isbnNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getBylanguage(String language) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getBygenre(String genre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getBynumberOfPages(int numberOfPAges) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book save(Book book) {
		return bookrepository.save(book);
	}

	@Override
	public Book update(Book book, long bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long bookId) {
		// TODO Auto-generated method stub
		
	}

	
}
