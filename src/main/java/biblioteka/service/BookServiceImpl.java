package biblioteka.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.mapping.Array;
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
		Optional<Book> bookokoko = bookrepository.findByBookId(bookId);;
		
			Book book1 = bookokoko.get();
		if(book.getAuthor() != null || book.getAuthor() !=book1.getAuthor()) {
			book.setAuthor(book1.getAuthor());
		}
		else {
			book.setAuthor(book1.getAuthor());
		}
		if(book.getGenre() != null || book.getGenre() !=book1.getGenre()) {
			book.setGenre(book1.getGenre());
		}
		else {
			book.setGenre(book1.getGenre());
		}
		
		if(book.getIsbnNumber() != 0 || book.getIsbnNumber() != book1.getIsbnNumber()) {
			
		}
		else {
			book.setIsbnNumber(book1.getIsbnNumber());
		}
		if(book.getLanguage() != null || book.getLanguage() !=book1.getLanguage()) {
			
		}
		else {
			book.setLanguage(book1.getLanguage());
		}
		if(book.getNumberOfPages() != 0 || book.getNumberOfPages()  !=book1.getNumberOfPages() ) {
			
		}else {
			book.setNumberOfPages(book1.getNumberOfPages());
		}
		if(book.getPublicher() != null|| book.getPublicher() !=book1.getPublicher()) {
			
		}else {
			book.setPublicher(book1.getPublicher());
		}
		if(book.getPublicingYear() != 0 || book.getPublicingYear() !=book1.getPublicingYear()) {
			
		}else {
			book.setPublicingYear(book1.getPublicingYear());
		}
		if(book.getTitle() != null|| book.getTitle() !=book1.getTitle()) {
			
		}else {
			book.setTitle(book1.getTitle());
		}
		if(book.getVat() != 0|| book.getVat() !=book1.getVat()) {
			
		}else {
			book.setVat(book1.getVat());
		}
		if(book.getWholesaleValue() != 0|| book.getWholesaleValue() !=book1.getWholesaleValue()) {
			
		}else {
			book.setWholesaleValue(book1.getWholesaleValue());
		}
		return bookrepository.saveAndFlush(book);
	}

	@Override
	public void delete(long bookId) {
		bookrepository.deleteById(bookId);
		
	}

	
}
