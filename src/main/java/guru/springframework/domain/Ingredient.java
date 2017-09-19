package guru.springframework.domain;

import java.math.BigDecimal;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(exclude = {"recipe"})
@Data
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private BigDecimal amount;
	
	@ManyToOne
	private Recipe recipe;
	
	@OneToOne // default FetchType.EAGER  
	private UnitOfMeasure unitOfMeasure;
	
}
