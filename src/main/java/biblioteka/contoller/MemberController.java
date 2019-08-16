package biblioteka.contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import biblioteka.model.Member;
import biblioteka.service.MemberService;

@RestController
@RequestMapping(value = "/members")
public class MemberController {
	@Autowired
	MemberService memberservice;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Member>> getAllMembers(){
		
		List<Member> member = memberservice.getAll();
		if(member.isEmpty()) {
			return new ResponseEntity<List<Member>>(HttpStatus.NO_CONTENT);
			
		}
		return new ResponseEntity<List<Member>>(member,HttpStatus.OK);
		
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Member> getMemberById(@PathVariable("id") long id  ){
		Optional<Member> member = memberservice.getByCardId(id);
		Member members = member.get();
		if(members==null) {
			
			return new ResponseEntity<Member>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Member>(members,HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Member> saveNewMember(@RequestBody Member member){
		
		Optional<Member> members= memberservice.getByCardId(member.getCardId());
		Member member1 = members.get();
		if(member1 == null) {
			memberservice.save(member);
			return new ResponseEntity<Member>(HttpStatus.OK);
		}
		return new ResponseEntity<Member>(HttpStatus.CONFLICT);
		
		
	}

}
