package tdtu.edu.gk_java.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tdtu.edu.gk_java.Entity.Cart;
import tdtu.edu.gk_java.Entity.Product;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findByProduct(Product product);

    boolean existsByProduct(Product product);

}
