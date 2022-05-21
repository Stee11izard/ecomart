package com.coursework.ecomart.repositories;

import org.springframework.data.repository.CrudRepository;

import com.coursework.ecomart.entities.Order;

public interface OrderRepo extends CrudRepository<Order, Long>{ 
    public Order getById(int id);
}