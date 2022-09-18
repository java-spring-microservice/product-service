package comjava.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import comjava.entity.Product;
import comjava.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    @GetMapping("/{productId}")
    public Product getProductDetail(@PathVariable Long productId) {
        return productRepository.findById(productId).orElse(null);
    }
}
