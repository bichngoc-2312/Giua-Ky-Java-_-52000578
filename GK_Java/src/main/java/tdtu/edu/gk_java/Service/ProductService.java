package tdtu.edu.gk_java.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tdtu.edu.gk_java.Entity.Product;
import tdtu.edu.gk_java.Repository.ProductReposition;
import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductReposition productReposition;

    public Product getProductById(Long id) {
        return productReposition.getProductById(id);
    }

    public Product save(Product product) {
        return productReposition.save(product);
    };

    public void deleteById(Long id) {
        productReposition.deleteById(id);
    }

    public List<Product> findAll() {
        return productReposition.findAll();
    }

    public List<Product> findByNameContaining(String keyword) {
        return productReposition.findByNameContaining(keyword);
    }

}
