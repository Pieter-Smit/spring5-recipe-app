package guru.springframework.bootstrap;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private RecipeRepository recipeRepository;
	
	private CategoryRepository categoryRepository;
	
	private UnitOfMeasureRepository unitOfMeasureRepository;
	
	
	
	public DevBootstrap(RecipeRepository recipeRepository, CategoryRepository categoryRepository,
			UnitOfMeasureRepository unitOfMeasureRepository) {
		super();
		this.recipeRepository = recipeRepository;
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initData();		
	}

	private void initData() {
		recipeRepository.save(createPerfectGuacamole());
		
	}
	
	private Recipe createPerfectGuacamole() {
		Recipe perfectGuacamole = new Recipe();
		perfectGuacamole.setDescription("The BEST guacamole! So easy to make with ripe avocados, salt, serrano chiles, cilantro and lime. Garnish with red radishes or jicama. Serve with tortilla chips.");
		perfectGuacamole.setDirections("1 Cut avocado" + 
				"\r\n" + 
				"2 Mash with a fork" + 
				"\r\n" + 
				"3 Add salt, lime juice, and the rest");
		//		perfectGuacamole.setImage(image);
		perfectGuacamole.setIngredients(getPerfectGuacamoleIngredients(perfectGuacamole));
		perfectGuacamole.setPrepTime(10);
		perfectGuacamole.setSource("Elise Bauer");
		perfectGuacamole.setCategories(new HashSet<>());
		perfectGuacamole.getCategories().add(categoryRepository.findByDescription("Mexican").get());
		
		return perfectGuacamole;
	}

	private Set<Ingredient> getPerfectGuacamoleIngredients(Recipe guacamoleRecipe) {
		UnitOfMeasure teaspoon = new UnitOfMeasure();
		teaspoon.setDescription("TeaSpoon");
		unitOfMeasureRepository.save(teaspoon); 
		UnitOfMeasure tablespoon = new UnitOfMeasure();
		tablespoon.setDescription("TableSpoon");
		unitOfMeasureRepository.save(tablespoon);
		
		Set<Ingredient> ingredients = new HashSet<>();
		Ingredient avocado = new Ingredient();
		avocado.setAmount(new BigDecimal(2));
		avocado.setDescription("avocado");
		avocado.setRecipe(guacamoleRecipe);
		ingredients.add(avocado);
		
		Ingredient salt = new Ingredient();
		salt.setAmount(new BigDecimal(1.5d));
		salt.setDescription("Kosher salt");
		salt.setUnitOfMeasure(teaspoon );
		salt.setRecipe(guacamoleRecipe);
		ingredients.add(salt);
		
		Ingredient juice = new Ingredient();
		juice.setAmount(new BigDecimal(1));
		juice.setDescription("lime or lemon juice");
		juice.setUnitOfMeasure(tablespoon);
		juice.setRecipe(guacamoleRecipe);
		ingredients.add(juice);
	
		
		return ingredients;
	}

}
