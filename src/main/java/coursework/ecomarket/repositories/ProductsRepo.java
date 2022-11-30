package coursework.ecomarket.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import coursework.ecomarket.entities.Products;

public interface ProductsRepo extends CrudRepository<Products, Integer> {
    List<Products> findAll();
    List<Products> findByCategory(String category);
    Products findById(int id);
}
