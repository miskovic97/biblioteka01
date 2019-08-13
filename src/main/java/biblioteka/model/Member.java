package biblioteka.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "member")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cardId", unique = true)
	private long cardId;
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

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "member")
	private Set<Book> books;

	@ManyToOne
	private Hall halls;

	@OneToOne(mappedBy = "members")
	private MembershipCard membershipcard;
}
