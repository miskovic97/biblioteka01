package biblioteka.dto;

import java.util.ArrayList;
import java.util.List;

import biblioteka.model.Author;

public class AuthorConverter {

	public List<AuthorDTO> convertToDto(List<Author> author1) {

		
		List<AuthorDTO> authorDTO = new ArrayList<AuthorDTO>();

		for (int i = 0; i < author1.size(); i++) {
			AuthorDTO authDto = new AuthorDTO();
			Author author = new Author();
			author = author1.get(i);
			authDto.setId(author.getId());
			authDto.setJmbg(author.getJmbg());
			authDto.setFullName(author.getFirstName() + " " + author.getLastName());
			authDto.setPseudonym(author.getPseudonym());
			authDto.setEmail(author.getEmail());
			authDto.setBirthYear(author.getBirthYear());

			authorDTO.add(authDto);
		}
		return authorDTO;

	}

	public List<Author> convertTOAuthor(List<AuthorDTO> authorDto) {
		
	List <Author> author = new ArrayList<Author>();
	
	for (int i = 0; i<authorDto.size();i++) {
		Author author1 = new Author();
		AuthorDTO authdto = new AuthorDTO();
		
		authdto = authorDto.get(i);
		String fullname = authdto.getFullName();
		int index = fullname.indexOf(" ");
		
		author1.setId(authdto.getId());
		author1.setJmbg(authdto.getJmbg());
		author1.setFirstName(fullname.substring(0, index));
		author1.setLastName(fullname.substring(index));
		author1.setPseudonym(authdto.getPseudonym());
		author1.setBirthYear(authdto.getBirthYear());
		author.add(author1);
	}
		return author;

	}
	
	public AuthorDTO covertToDTO1 (Author author) {
		AuthorDTO authordto = new AuthorDTO();
		authordto.setId(author.getId());
		authordto.setBirthYear(author.getBirthYear());
		authordto.setEmail(author.getEmail());
		authordto.setFullName(author.getFirstName() + " "+author.getLastName());
		authordto.setJmbg(author.getJmbg());
		authordto.setPseudonym(author.getPseudonym());
		
		
		return authordto;
	}
	
	public Author convertToAuthor(AuthorDTO authordto) {
		Author author = new Author();
		
		
		
		String fullname = authordto.getFullName();
		int index = fullname.indexOf(" ");
		
		author.setId(authordto.getId());
		author.setJmbg(authordto.getJmbg());
		author.setFirstName(fullname.substring(0, index));
		author.setLastName(fullname.substring(index));
		author.setPseudonym(authordto.getPseudonym());
		author.setBirthYear(authordto.getBirthYear());
	
		
		return author;
		
		
		
	}
	
}
