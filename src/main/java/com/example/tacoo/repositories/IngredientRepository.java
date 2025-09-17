package com.example.tacoo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tacoo.models.Ingredient;


public interface IngredientRepository extends JpaRepository<Ingredient, String>{

}
