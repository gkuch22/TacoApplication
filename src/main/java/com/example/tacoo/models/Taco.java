package com.example.tacoo.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Taco {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private Date createdAt = new Date();
	
	@NotNull
	@Size(min=5, message="Name must be at least 5 characters long")
	private String name;
	
	@Size(min=1, message="You must choose at least 1 ingredient")
	@ManyToMany
	@JoinTable(
			name = "taco_ingredients",
			joinColumns = @JoinColumn(name = "taco_id"),
			inverseJoinColumns = @JoinColumn(name = "ingredient_id")
	)
	private List<Ingredient> ingredients = new ArrayList<>();
	
	public void addIngredient(Ingredient ingredient) {
		this.ingredients.add(ingredient);
	}
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private TacoOrder tacoOrder;
	
	
}
