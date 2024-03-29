package coursework.ecomarket.repositories;

import org.springframework.data.repository.CrudRepository;

import coursework.ecomarket.entities.Client;

public interface ClientRepo extends CrudRepository<Client, Integer> {
    Client findByUsername(String username);
    Client findById(int id);
}
