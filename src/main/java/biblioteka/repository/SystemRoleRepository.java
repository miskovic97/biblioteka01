package biblioteka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biblioteka.model.SystemRole;
@Repository
public interface SystemRoleRepository extends JpaRepository<SystemRole, String> {

}
