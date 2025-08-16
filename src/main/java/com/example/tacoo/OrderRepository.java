package com.example.tacoo;

import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<TacoOrder, Long>{
	
}
