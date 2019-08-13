package biblioteka.service;

import java.util.List;
import java.util.Optional;

import biblioteka.model.Library;

public interface LibraryService {
	Optional<Library> getById(long Id);

	List<Library> getAll();

	Library save(Library library);

	Library update(Library library, long id);
	
	void delete(long id);
}
