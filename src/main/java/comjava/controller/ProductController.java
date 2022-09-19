package comjava.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getProductList() {

        logger.info("getProductList");
        return productRepository.findAll();
    }

    @GetMapping("/{productId}")
    public Product getProductDetail(@PathVariable Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @GetMapping("/test/exception")
    public Product testException() {
        throw new RuntimeException("Exception");
    }

    public Product getProductDefault() {
        return Product.builder().id(0L).name("default").price(0.0).quantity(0L).build();
    }
}
