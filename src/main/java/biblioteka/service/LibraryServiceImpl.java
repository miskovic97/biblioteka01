package biblioteka.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteka.model.Library;
import biblioteka.repository.LibraryRepository;

@Service
public class LibraryServiceImpl implements LibraryService {
	@Autowired
	LibraryRepository libraryrepository;
	@Override
	public List<Library> getAll() {
		return libraryrepository.findAll();
	}

	@Override
	public Optional<Library> getById(long Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Library save(Library library) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Library update(Library library, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}
}
