package com.coursework.ecomart.repositories;

import org.springframework.data.repository.CrudRepository;

import com.coursework.ecomart.entities.Carts;

public interface CartRepo extends CrudRepository<Carts, Long>{
}
