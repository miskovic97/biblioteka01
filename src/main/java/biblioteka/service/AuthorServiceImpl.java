package biblioteka.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteka.model.Author;
import biblioteka.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService{
	@Autowired
	AuthorRepository authorRepository;
	
	@Override
	public List<Author> getAll() {
		return authorRepository.findAll();
	}
	
	@Override
	public List<Author> getbybirthYear(int birthYear) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Author> getById(long id) {
		return authorRepository.findById(id);
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
		return authorRepository.save(author);
	}

	@Override
	public Author update(Author author, long id) {
		return authorRepository.saveAndFlush(author);
		
	}

	@Override
	public void delete(long id) {
		authorRepository.deleteById(id);
		
	}

	@Override
	public List<Author> getByJmbg(long jmbg) {
		return authorRepository.findByJmbg(jmbg);
	}

	@Override
	public Optional<Author> geByfirstAndlastName(String firstName, String lastName) {
		return authorRepository.findByFirstNameAndLastName(firstName, lastName);
	}
	

}
