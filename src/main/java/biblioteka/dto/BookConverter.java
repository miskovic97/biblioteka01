package biblioteka.dto;

import java.util.ArrayList;
import java.util.List;

import biblioteka.model.Book;

public class BookConverter {

	public BookDTO convertToDto(Book book) {
		BookDTO bookdto = new BookDTO();
		
		bookdto.setAuthor(book.getAuthor());
		bookdto.setBookId(book.getBookId());
		bookdto.setGenre(book.getGenre());
		bookdto.setIsbnNumber(book.getIsbnNumber());
		bookdto.setLanguage(book.getLanguage());
		bookdto.setNumberOfPages(book.getNumberOfPages());
		bookdto.setPublicher(book.getPublicher());
		bookdto.setPublicingYear(book.getPublicingYear());
		bookdto.setVat(book.getVat());
		bookdto.setRetailValue(book.getWholesaleValue() + ((book.getWholesaleValue()*book.getVat())/100));
		bookdto.setTitle(book.getTitle());
		return bookdto;
		
	}
	public List<BookDTO> convertTODto(List<Book> book){
		
		List<BookDTO> bookdto= new ArrayList<BookDTO>();
		
		for (int i= 0; i< book.size(); i++) {
			Book book1 = book.get(i);
			BookDTO bookdto1 =new BookDTO();
			
			bookdto1.setAuthor(book1.getAuthor());
			bookdto1.setTitle(book1.getTitle());
			bookdto1.setBookId(book1.getBookId());
			bookdto1.setGenre(book1.getGenre());
			bookdto1.setIsbnNumber(book1.getIsbnNumber());
			bookdto1.setLanguage(book1.getLanguage());
			bookdto1.setNumberOfPages(book1.getNumberOfPages());
			bookdto1.setPublicher(book1.getPublicher());
			bookdto1.setPublicingYear(book1.getPublicingYear());
			bookdto1.setVat(book1.getVat());
			bookdto1.setRetailValue(book1.getWholesaleValue() + ((book1.getWholesaleValue()*book1.getVat())/100));
			
			bookdto.add(bookdto1);
		}
		
		return bookdto;
	}
public List<Book> convertTOBook(List<BookDTO> bookdto){
		
		List<Book> book= new ArrayList<Book>();
		
		for (int i= 0; i< bookdto.size(); i++) {
			BookDTO bookdto1 = bookdto.get(i);
			Book book1 =new Book();
			
			book1.setAuthor(bookdto1.getAuthor());
			book1.setTitle(bookdto1.getTitle());
			book1.setBookId(bookdto1.getBookId());
			book1.setGenre(bookdto1.getGenre());
			book1.setIsbnNumber(bookdto1.getIsbnNumber());
			book1.setLanguage(bookdto1.getLanguage());
			book1.setNumberOfPages(bookdto1.getNumberOfPages());
			book1.setPublicher(bookdto1.getPublicher());
			book1.setPublicingYear(bookdto1.getPublicingYear());
			book1.setVat(bookdto1.getVat());
			book1.setWholesaleValue((bookdto1.getRetailValue() *100)/(100 + bookdto1.getVat()));
			
			book.add(book1);
		}
		
		return book;
	}
public Book convertToBook(BookDTO bookdto) {
	Book book = new Book();
	
	book.setAuthor(bookdto.getAuthor());
	book.setTitle(bookdto.getTitle());
	book.setBookId(bookdto.getBookId());
	book.setGenre(bookdto.getGenre());
	book.setIsbnNumber(bookdto.getIsbnNumber());
	book.setLanguage(bookdto.getLanguage());
	book.setNumberOfPages(bookdto.getNumberOfPages());
	book.setPublicher(bookdto.getPublicher());
	book.setPublicingYear(bookdto.getPublicingYear());
	book.setVat(bookdto.getVat());
	book.setWholesaleValue((bookdto.getRetailValue() *100)/(bookdto.getVat()+100));

	
	return book;
	
}
	
}
