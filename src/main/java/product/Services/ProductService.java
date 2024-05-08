package product.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import product.entities.Product;
import product.repositories.ProductRepository;
import java.util.*;


@Service
public class ProductService {

    private final ProductRepository productRepository;

 
    
    public ProductService(ProductRepository productRepository) 
    {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Product getProductById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public Product updateProduct(String id, Product updatedProduct) {
        Product existingProduct = getProductById(id);
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setCategories(updatedProduct.getCategories());
        existingProduct.setAttributes(updatedProduct.getAttributes());
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(String id) {
        Product existingProduct = getProductById(id);
        productRepository.delete(existingProduct);
    }

    public List<Product> searchProducts(String name, String categories, String attributes) {
        if (name != null && categories != null && attributes != null) {
            return productRepository.findByNameAndCategoriesAndAttributes(name, categories, attributes);
        } else if (name != null && categories != null) {
            return productRepository.findByNameAndCategories(name, categories);
        } else if (name != null) {
            return productRepository.findByName(name);
        } else if (categories != null) {
            return productRepository.findByCategories(categories);
        } else {
            return productRepository.findAll();
        }
    }
}
