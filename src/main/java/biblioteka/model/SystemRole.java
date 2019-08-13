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
@Table(name = "systemrole")
public class SystemRole {
	
	@Id
	private String name;
	
	@Column
	private long id;
	 
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="userrole",joinColumns = {@JoinColumn(referencedColumnName = "name")},
	inverseJoinColumns={@JoinColumn(referencedColumnName="userid")})
	private Set<User> users;
}