package biblioteka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biblioteka.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
