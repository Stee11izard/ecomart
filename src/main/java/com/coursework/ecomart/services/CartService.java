package com.coursework.ecomart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursework.ecomart.entities.Carts;
import com.coursework.ecomart.repositories.CartRepo;

@Service
public class CartService {
    @Autowired
    CartRepo cRepo;

    public void update(Carts cart) {
        cRepo.save(cart);
    }
}
