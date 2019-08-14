
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
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "book", uniqueConstraints = { @UniqueConstraint(columnNames = "bookid"),
		@UniqueConstraint(columnNames = "isbnnumber") })
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long bookId;
	
	@Column
	private String author;
	
	@Column
	private String title;
	
	@Column
	private int publicingYear;
	
	
	
	@Column
	private String publicher;
	
	@Column(name = "isbnnumber", unique = true, nullable = false)
	private long isbnNumber;
	
	@Column
	private int numberOfPages;
	
	@Column
	private String language;
	
	@Column
	private String genre;
	
	@ManyToOne
	private Library library;
	
	@ManyToOne
	private Member member;
	
	@ManyToMany(mappedBy = "books")
	public Set<Author> authors;
}
