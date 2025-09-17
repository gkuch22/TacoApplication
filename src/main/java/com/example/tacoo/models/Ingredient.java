package com.example.tacoo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
public class Ingredient {
	@Id
	public final String id;
	
	public final String name;
	
	@Enumerated(EnumType.STRING)
	public final Type type;
	
	public enum Type{
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}
	
}
