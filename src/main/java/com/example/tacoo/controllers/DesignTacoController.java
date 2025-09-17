package com.example.tacoo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.tacoo.models.Ingredient;
import com.example.tacoo.models.Taco;
import com.example.tacoo.models.TacoOrder;
import com.example.tacoo.models.Ingredient.Type;
import com.example.tacoo.repositories.IngredientRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

	private final IngredientRepository ingredientRepository;
	
	public DesignTacoController(IngredientRepository ingredientRepository) {
		this.ingredientRepository = ingredientRepository;
	}
	
	@ModelAttribute(name = "tacoOrder")
	public TacoOrder order() {
		return new TacoOrder();
	}
	
	@ModelAttribute(name = "taco")
	public Taco taco() {
		return new Taco();
	}
	
	@ModelAttribute
	public void addIngredientsToModel(Model model) {
	    Iterable<Ingredient> ingredients = ingredientRepository.findAll();
	    
	    List<Ingredient> ingredientsList = new ArrayList<>();
	    for(Ingredient ingredient : ingredients) {
	    	ingredientsList.add(ingredient);
	    }
	    
	    Type[] types = Ingredient.Type.values();
	    for (Type type : types) {
	      model.addAttribute(
	    		  type.toString().toLowerCase(), 
	    		  filterByType(ingredientsList, type));
	    }
	  }
	
	private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
		return ingredients
		          .stream()
		          .filter(x -> x.getType().equals(type))
		          .collect(Collectors.toList());
	}
	
	
	@GetMapping
	public String showDesignForm() {
		return "design";
	}
	
	@PostMapping
	public String processTaco(@Valid Taco taco, Errors errors, 
									@ModelAttribute TacoOrder tacoOrder) {
		if(errors.hasErrors()) {
			return "design";
		}
		
		tacoOrder.addTaco(taco);
		
//		log.info("processing taco: {}", taco);
		return "redirect:/orders/current";
	}
	
	
	
	
	
	
}
