package biblioteka.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biblioteka.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
	
	List<Author> findByFirstName(String firstName);
	
	List<Author> findByJmbg(long jmbg);
	
	Optional<Author> findByFirstNameAndLastName(String firstName, String lastName);
	
	
	
}
