package biblioteka.service;

import java.util.List;
import java.util.Optional;

import biblioteka.model.MembershipCard;

public interface MembershipCardService {
	List<MembershipCard> getAll();

	Optional<MembershipCard> getByid(long id);

	MembershipCard save(MembershipCard membershipCard);

	MembershipCard update(MembershipCard mebershipCard, long id);

	void delete(long id);
}
