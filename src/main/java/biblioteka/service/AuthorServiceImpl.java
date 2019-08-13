package biblioteka.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import biblioteka.model.Author;
import biblioteka.repository.AuthorRepository;

public class AuthorServiceImpl implements AuthorService{
	@Autowired
	AuthorRepository authorRepository;
	
	@Override
	public List<Author> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Author> getbybirthYear(int birthYear) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Author> getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Author> getByfirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Author> getbylastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Author> getbypseudonym(String pseudonym) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author save(Author author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author update(Author author, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}
	

}
