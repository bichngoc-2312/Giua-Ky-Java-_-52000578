package tdtu.edu.gk_java.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tdtu.edu.gk_java.Entity.Product;

@Repository
public interface ProductReposition extends JpaRepository<Product, Long> {
    List<Product> findByNameContaining(String keyword);

    Product getProductById(Long id);
}
