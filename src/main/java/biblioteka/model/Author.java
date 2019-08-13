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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "author")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String pseudonym;
	
	@Column
	private int birthYear;
	
	@Column
	private String email;
	

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "authorbook", joinColumns = { @JoinColumn(referencedColumnName = "id") }, inverseJoinColumns = {
			@JoinColumn(referencedColumnName = "bookId") })
	public Set<Book> books;
}
