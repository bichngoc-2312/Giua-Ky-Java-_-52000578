package tdtu.edu.gk_java.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tdtu.edu.gk_java.Entity.Cart;
import tdtu.edu.gk_java.Entity.Product;
import tdtu.edu.gk_java.Repository.CartRepository;

import java.util.List;

@Service
@Transactional
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    public Cart findById(Long id) {
        return cartRepository.findById(id).get();
    }

    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    };

    public void deleteById(Long id) {
        cartRepository.deleteById(id);
    }

    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    public boolean existsByProduct(Product product) {
        List<Cart> carts = cartRepository.findAll();
        for (Cart cart : carts) {
            if (cart.getProduct().getId() == product.getId()) {
                return true;
            }
        }
        return false;
    }

    public Cart findByProduct(Product product) {
        List<Cart> carts = cartRepository.findAll();
        for (Cart cart : carts) {
            if (cart.getProduct().getId() == product.getId()) {
                return cart;
            }
        }
        return null;
    }

}
