package biblioteka.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userid;
	
	@Column
	private String firstName;
	
	@Column 
	private String lastName;
	
	@Column
	private String username;
	
	@Column
	private String email;
	
	@Column
	private int birthyear;
	
	@Column
	private long phonenumber;
	
	@Column
	private String facebookProfileName;
	
	@Column
	private String password;
	@ManyToOne
	private Library library;
	
	@ManyToMany(mappedBy = "users")
	private Set<SystemRole> systemRoles;
}
