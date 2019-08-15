package biblioteka.dto;

import lombok.Data;

@Data
public class AuthorDTO {

		private long id;
		
		private long jmbg;
		
		private String fullName;
		private String pseudonym;
		private int birthYear;
		private String email;
		
		
}
