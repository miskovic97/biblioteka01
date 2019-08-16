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

import biblioteka.dto.AuthorConverter;
import biblioteka.dto.AuthorDTO;
import biblioteka.model.Author;
import biblioteka.service.AuthorService;

@RestController
@RequestMapping(value = "/author")
public class AuthorController {

	@Autowired
	AuthorService authorservice;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AuthorDTO>> listAllAuthors() {

		List<Author> author = authorservice.getAll();

		if (author.isEmpty()) {

			return new ResponseEntity<List<AuthorDTO>>(HttpStatus.NO_CONTENT);
		}
		List<AuthorDTO> authorDTo;
		AuthorConverter converter = new AuthorConverter();
		authorDTo = converter.convertToDto(author);
		return new ResponseEntity<List<AuthorDTO>>(authorDTo, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<AuthorDTO> listAuthorById(@PathVariable("id") long id) {
		Optional<Author> optionalAuthor = authorservice.getById(id);
		Author author = optionalAuthor.get();
		if (author == null) {
			return new ResponseEntity<AuthorDTO>(HttpStatus.NOT_FOUND);
		}
		AuthorDTO authordto;
		AuthorConverter converter = new AuthorConverter();
		authordto = converter.covertToDTO1(author);
		return new ResponseEntity<AuthorDTO>(authordto, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO authordto) {
		AuthorConverter converter = new AuthorConverter();
<<<<<<< HEAD
		Author author= converter.convertToAuthor(authordto);
		
=======
		Author author = converter.convertToAuthor(authordto);
>>>>>>> controler
		List<Author> authors = authorservice.getByJmbg(author.getJmbg());
		if (authors.isEmpty()) {
			authorservice.save(author);
			return new ResponseEntity<AuthorDTO>(HttpStatus.CREATED);
<<<<<<< HEAD
			
		}
		return new ResponseEntity<AuthorDTO>(HttpStatus.CONFLICT);
			
=======

		}
		return new ResponseEntity<AuthorDTO>(HttpStatus.CONFLICT);

>>>>>>> controler
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateHall(@PathVariable("id") long id, @RequestBody AuthorDTO authordto) {
		Optional<Author> authors = authorservice.getById(id);
		Author currentAuthors = authors.get();
		if (currentAuthors == null) {
			return new ResponseEntity<AuthorDTO>(HttpStatus.NOT_FOUND);
		}
		AuthorConverter converter = new AuthorConverter();

		Author author = converter.convertToAuthor(authordto);
		currentAuthors.setId(id);
		currentAuthors.setJmbg(author.getJmbg());
		currentAuthors.setFirstName(author.getFirstName());
		currentAuthors.setLastName(author.getLastName());
		currentAuthors.setPseudonym(author.getPseudonym());
		currentAuthors.setBirthYear(author.getBirthYear());
		currentAuthors.setEmail(author.getEmail());
		authorservice.update(currentAuthors, id);

		AuthorDTO currentAuthordto = converter.covertToDTO1(currentAuthors);
		return new ResponseEntity<AuthorDTO>(currentAuthordto, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteHall(@PathVariable("id") long id) {

		Optional<Author> author = authorservice.getById(id);
		Author authors = author.get();
		if (authors == null) {
			return new ResponseEntity<AuthorDTO>(HttpStatus.NOT_FOUND);
		}
		authorservice.delete(id);
		return new ResponseEntity<AuthorDTO>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{fullName}/name", method = RequestMethod.GET)
	public ResponseEntity<AuthorDTO> listAuthorById(@PathVariable("fullName") String fullName) {
		Author author = new Author();
		author.setFirstName(fullName.substring(0, fullName.indexOf(" ")));
		author.setLastName(fullName.substring(fullName.indexOf(" ")));
		Optional<Author> optionalAuthor = authorservice.geByfirstAndlastName(author.getFirstName(),author.getLastName());
		Author author1 = optionalAuthor.get();
		if (author1 == null) {
			return new ResponseEntity<AuthorDTO>(HttpStatus.NOT_FOUND);
		}
		AuthorConverter converter = new AuthorConverter();
		AuthorDTO authordto = converter.covertToDTO1(author1);
		return new ResponseEntity<AuthorDTO>(authordto, HttpStatus.OK);

	}

}
