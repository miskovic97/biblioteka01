package biblioteka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biblioteka.model.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long>{

}
