package biblioteka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biblioteka.model.Author;
import java.lang.String;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
	
	List<Author> findByfirstName(String firstName);
	
	
}
