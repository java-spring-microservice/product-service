package comjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import comjava.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
