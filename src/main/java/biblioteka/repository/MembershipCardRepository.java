package biblioteka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biblioteka.model.MembershipCard;

@Repository
public interface MembershipCardRepository extends JpaRepository<MembershipCard, Long> {

}
