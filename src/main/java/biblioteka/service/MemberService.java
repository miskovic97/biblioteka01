package biblioteka.service;

import java.util.List;
import java.util.Optional;

import biblioteka.model.Member;

public interface MemberService {
	List<Member> getAll();

	Optional<Member> getByCardId(long cardId);

	Member save(Member member);

	Member update(Member member, long cardId);

	void delete(long cardId);
}
