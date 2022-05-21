package com.coursework.ecomart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursework.ecomart.entities.Order;
import com.coursework.ecomart.repositories.OrderRepo;

@Service
public class OrderService {
    @Autowired
    OrderRepo oRepo;

    public void saveChanges(Order order) {
        oRepo.save(order);
    }
    public Order getOrderById(int id) {
        return oRepo.getById(id);
    }
}
