package biblioteka.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteka.model.Member;
import biblioteka.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberRepository memberrepository;
	@Override
	public Optional<Member> getByCardId(long cardId) {
		return memberrepository.findById(cardId);
	}

	@Override
	public List<Member> getAll() {
		return memberrepository.findAll();
	}

	@Override
	public Member save(Member member) {
		return memberrepository.save(member);
	}

	@Override
	public Member update(Member member, long cardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long cardId) {
		// TODO Auto-generated method stub

	}
}
