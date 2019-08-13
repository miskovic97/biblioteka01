package biblioteka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "membershipcard")
public class MembershipCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private String city;

	@OneToOne
	@JoinColumn(name = "cardId")
	public Member members;

	@ManyToOne
	private Library libarary;

}
