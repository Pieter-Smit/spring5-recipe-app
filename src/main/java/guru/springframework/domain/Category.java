package guru.springframework.domain;

import java.util.Set;

import javax.persistence.*;
@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	@ManyToMany(mappedBy = "categories")
	private Set<Recipe> recepies;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Set<Recipe> getRecepies() {
		return recepies;
	}


	public void setRecepies(Set<Recipe> recepies) {
		this.recepies = recepies;
	}

}
