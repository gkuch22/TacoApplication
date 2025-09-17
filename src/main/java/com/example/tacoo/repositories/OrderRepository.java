package com.example.tacoo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tacoo.models.TacoOrder;


public interface OrderRepository extends JpaRepository<TacoOrder, Long>{
	
}
