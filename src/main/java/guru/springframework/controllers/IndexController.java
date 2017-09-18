package guru.springframework.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import guru.springframework.services.RecipeService;

@Controller
public class IndexController {

	private CategoryRepository categoryRepository;
	
	private UnitOfMeasureRepository unitOfMeasureRepository;
	
private RecipeService recipeService;	
	
	public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository,
			RecipeService recipeService) {
		super();
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
		this.recipeService = recipeService;
	}




	@RequestMapping({"","/","/index"})
	public String getIndexPage(Model model) {
		
		model.addAttribute("recipies", recipeService.getRecipies());
		
		Optional<Category> categoryOptional = categoryRepository.findByDescription("Italian");
		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Cup");
		
		
		System.out.println("cat id = " + categoryOptional.get().getId());
		System.out.println("uom id = " + (uomOptional.isPresent()?uomOptional.get().getId(): null));
		
		
		return "index";
	}
}
