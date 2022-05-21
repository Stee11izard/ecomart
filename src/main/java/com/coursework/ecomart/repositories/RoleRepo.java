package com.coursework.ecomart.repositories;

import org.springframework.data.repository.CrudRepository;

import com.coursework.ecomart.entities.UserRole;

public interface RoleRepo extends CrudRepository<UserRole, Long>{
    
}
