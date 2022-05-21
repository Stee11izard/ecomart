package com.coursework.ecomart.repositories;

import org.springframework.data.repository.CrudRepository;

import com.coursework.ecomart.entities.Client;

public interface ClientRepo extends CrudRepository<Client, Long> {
    Client findByUsername(String username);
    Client findById(int id);
}
