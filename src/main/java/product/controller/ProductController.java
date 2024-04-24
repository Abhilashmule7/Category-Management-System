package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import product.entities.Product;
import product.repositories.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/getAllProducts")
    public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size,
                                        @RequestParam(defaultValue = "name") String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return productRepository.findAll(pageable);
    }

    @GetMapping("/getProductById/{id}")
    public Product getProductById(@PathVariable String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    @PutMapping("/updateProduct/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product updatedProduct) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setCategories(updatedProduct.getCategories());
        existingProduct.setAttributes(updatedProduct.getAttributes());

        return productRepository.save(existingProduct);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable String id) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        productRepository.delete(existingProduct);
    }

    @GetMapping("/searchProducts")
    public List<Product> searchProducts(@RequestParam(required = false) String name,
                                        @RequestParam(required = false) String categories,
                                        @RequestParam(required = false) String attributes) {
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
