package biblioteka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biblioteka.model.Hall;

@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {
	
}
