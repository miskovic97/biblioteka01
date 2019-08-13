package biblioteka.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import lombok.Data;

@Entity
@Table(name = "library")
@Data
public class Library {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = true, nullable = false)
	private String name;

	@Column
	private String city;

	@Column
	private String adress;

	@Column(name = "PHONE_NUMBER", unique = true, nullable = true)
	private long phoneNumber;

	@Column(name = "EMAIL", unique = true, nullable = true)
	private String email;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "library")
	private Set<Book> books;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "library")
	private Set<Hall> halls;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "library")
	private Set<MembershipCard> membershipcard;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "library")
	private Set<User> users;
}
