package biblioteka.service;

import java.util.List;
import java.util.Optional;

import biblioteka.model.Author;

public interface AuthorService {
	List<Author> getAll();

	Optional<Author> getById(long id);

	List<Author> getByfirstName(String firstName);

	List<Author> getbylastName(String lastName);

	List<Author> getbypseudonym(String pseudonym);

	List<Author> getbybirthYear(int birthYear);

	Author save(Author author);

	Author update(Author author, long id);

	void delete(long id);

}
