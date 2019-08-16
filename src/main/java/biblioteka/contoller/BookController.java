package biblioteka.contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import biblioteka.dto.BookConverter;
import biblioteka.dto.BookDTO;
import biblioteka.model.Book;
import biblioteka.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	BookService bookservice;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<BookDTO>> listAllBooks() {
		List<Book> book = bookservice.getAll();
		if (book.isEmpty()) {
			return new ResponseEntity<List<BookDTO>>(HttpStatus.NO_CONTENT);
		}
		BookConverter bookConverter = new BookConverter();
		List<BookDTO> bookdto = bookConverter.convertTODto(book);

		return new ResponseEntity<List<BookDTO>>(bookdto, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookdto) {

		List<Book> books = bookservice.getBytitle(bookdto.getTitle());

		if (books.isEmpty()) {
			BookConverter converter = new BookConverter();
			Book book1 = converter.convertToBook(bookdto);
			bookservice.save(book1);
			return new ResponseEntity<BookDTO>(HttpStatus.CREATED);

		}

		return new ResponseEntity<BookDTO>(HttpStatus.NOT_FOUND);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<BookDTO> listBooksById(@PathVariable("id") long id) {
		Optional<Book> optionalBook = bookservice.getByBookId(id);
		Book book = optionalBook.get();
		BookConverter converter = new BookConverter();
		BookDTO bookdto = converter.convertToDto(book);
		if (book == null) {
			return new ResponseEntity<BookDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<BookDTO>(bookdto, HttpStatus.OK);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<BookDTO> changeBooks(@PathVariable("id") long id, @RequestBody BookDTO bookdto) {
		Optional<Book> book = bookservice.getByBookId(id);
		Book book1 = book.get();

		if (book1 == null) {
			return new ResponseEntity<BookDTO>(HttpStatus.NOT_FOUND);
		}
		BookConverter converter = new BookConverter();
		Book book2 = converter.convertToBook(bookdto);
		
		
		
		book1.setGenre(book2.getGenre());
		book1.setIsbnNumber(book2.getIsbnNumber());
		book1.setLanguage(book2.getLanguage());
		book1.setNumberOfPages(book2.getNumberOfPages());
		book1.setPublicher(book2.getPublicher());
		book1.setPublicingYear(book2.getPublicingYear());
		book1.setTitle(book2.getTitle());
		book1.setVat(book2.getVat());
		book1.setWholesaleValue(book2.getWholesaleValue());

		bookservice.update(book1, id);
		return new ResponseEntity<BookDTO>(HttpStatus.OK);

	}
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteBookById(@PathVariable("id") long id){
		Optional<Book> book = bookservice.getByBookId(id);
		Book book1 = book.get();
		
		if(book1 == null) {
			return new ResponseEntity<BookDTO>(HttpStatus.NOT_FOUND);
		}
		bookservice.delete(id);
		return new ResponseEntity<BookDTO>(HttpStatus.NO_CONTENT);
		
		
		
	}
}
