package guru.springframework.domain;

import java.util.Set;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@EqualsAndHashCode(exclude = {"recipies"})
@Data
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	@ManyToMany(mappedBy = "categories")
	private Set<Recipe> recepies;

}
