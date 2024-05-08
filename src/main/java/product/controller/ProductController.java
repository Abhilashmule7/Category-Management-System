package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import product.Services.ProductService;
import product.entities.Product;


import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController 
{
	@Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/getAllProducts")
    public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size,
                                        @RequestParam(defaultValue = "name") String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return productService.getAllProducts(pageable);
    }

    @GetMapping("/getProductById/{id}")
    public Product getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @PutMapping("/updateProduct/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product updatedProduct) {
        return productService.updateProduct(id, updatedProduct);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/searchProducts")
    public List<Product> searchProducts(@RequestParam(required = false) String name,
                                        @RequestParam(required = false) String categories,
                                        @RequestParam(required = false) String attributes) {
        return productService.searchProducts(name, categories, attributes);
    }
}
