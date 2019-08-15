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

import biblioteka.model.Book;
import biblioteka.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	BookService bookservice;
	
	@RequestMapping(method =RequestMethod.GET)
	public ResponseEntity<List<Book>> listAllBooks(){
		List<Book> book = bookservice.getAll();
		if(book.isEmpty()) {
			return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Book>>(book, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity <Book> createBook(@RequestBody Book book){
		
		List<Book> books= bookservice.getBytitle(book.getTitle());

		if (books.isEmpty()) {
			bookservice.save(book);
			return new ResponseEntity<Book>(HttpStatus.CREATED);
			
		}
		return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		
		
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Book> listHallsById(@PathVariable("id") long id) {
		Optional<Book> optionalBook = bookservice.getByBookId(id);
		Book book = optionalBook.get();
		if (book == null) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Book>(book, HttpStatus.OK);

	}
}
