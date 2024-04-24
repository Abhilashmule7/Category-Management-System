package product.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import product.entities.Product;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByNameAndCategoriesAndAttributes(String name, String categories, String attributes);
    List<Product> findByNameAndCategories(String name, String categories);
    List<Product> findByName(String name);
    List<Product> findByCategories(String categories);
}