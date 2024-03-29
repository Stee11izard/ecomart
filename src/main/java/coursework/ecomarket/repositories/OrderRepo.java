package coursework.ecomarket.repositories;

import org.springframework.data.repository.CrudRepository;

import coursework.ecomarket.entities.Order;

public interface OrderRepo extends CrudRepository<Order, Integer>{
    public Order getById(int id);
}