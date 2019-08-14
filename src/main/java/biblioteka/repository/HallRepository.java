package biblioteka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biblioteka.model.Hall;

@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {
	
	List<Hall> findByName(String name);
	
}
