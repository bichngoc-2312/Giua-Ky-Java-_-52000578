package tdtu.edu.gk_java.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tdtu.edu.gk_java.Entity.Cart;
import tdtu.edu.gk_java.Entity.Product;
import tdtu.edu.gk_java.Repository.CartRepository;
import tdtu.edu.gk_java.Repository.ProductReposition;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Controller
public class AppController {
    @Autowired
    private ProductReposition productReposition;

    @Autowired
    private CartRepository cartRepository;

    @RequestMapping("/homepage")
    public String getAllProducts(Model model) {
        List<Product> products = productReposition.findAll();
        model.addAttribute("products", products);
        return "homepage";
    }

    @RequestMapping(value = "/login_form", method = RequestMethod.POST)
    public String loginForm(@RequestParam(value = "username", required = false) String username,
                            @RequestParam(value = "password", required = false) String password,
                            Model model) {
        if (username != null && password != null) {
            if (username.equals("bichngoc") && password.equals("123")) {
                return "redirect:/homepage";
            } else if (!username.equals("bichngoc")) {
                model.addAttribute("error", "Username is incorrect");

            } else {
                model.addAttribute("error", "Username or password is incorrect");
            }
        }
        return "login";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm(Model model) {
        model.addAttribute("product", new Product());
        return "add";
    }

    @RequestMapping("/")
    public String index() {
        return "login";
    }

    @PostMapping("/add-product")
    public String addProduct(@RequestParam("name") String name, @RequestParam("price") int price,
                             @RequestParam("brand") String brand, @RequestParam("category") String category,
                             @RequestParam("description") String description, @RequestParam("image") MultipartFile image,
                             @RequestParam("color") String color,
                             Model model) {
        try {
            byte[] imageBytes = image.getBytes();

            Product product = new Product();
            product.setName(name);
            product.setPrice(price);
            product.setBrand(brand);
            product.setCategory(category);
            product.setColor(color);
            product.setDescription(description);
            product.setImage(Base64.getEncoder().encodeToString(imageBytes));
            productReposition.save(product);

            return "redirect:/homepage";
        } catch (IOException e) {
            e.printStackTrace();
            return "add-product";
        }
    }

    @RequestMapping("/add-product")
    public String addProduct(Model model) {
        return "addpro";
    }

    // xoa san pham theo id
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id, Model model) {
        productReposition.deleteById(id);
        return "redirect:/homepage";
    }

    // tim kiem san pham theo key word
    @RequestMapping("/search")
    public String searchProduct(@RequestParam("key") String keyword, Model model) {
        List<Product> products = productReposition.findByNameContaining(keyword);
        model.addAttribute("products", products);
        return "homepage";
    }

    // hien thi thong tin san pham theo id
    @RequestMapping("/detail/{id}")
    public String detailProduct(@PathVariable("id") Long id, Model model) {
        Product product = productReposition.findById(id).get();
        model.addAttribute("product", product);
        return "showdetail";
    }

    @RequestMapping("/addtocart/{id}")
    public String addProductToCart(@PathVariable("id") Long id, @RequestParam("quantity") int quantity, Model model) {
        Product product = productReposition.getProductById(id);
        // check if product is in cart
        if (cartRepository.existsByProduct(product)) {
            Cart cart = cartRepository.findByProduct(product);
            cart.setQuantity(cart.getQuantity() + 1);
            cart.setTotalPrice(cart.getQuantity() * cart.getProduct().getPrice());
            cartRepository.save(cart);
        } else {
            Cart cart = new Cart();
            cart.setProduct(product);
            cart.setQuantity(quantity);
            cart.setTotalPrice(quantity * product.getPrice());
            cartRepository.save(cart);
        }
        return "redirect:/cart";
    }

    // hien thi tong so tien trong gio hang
    @RequestMapping("/cart")
    public String showCart(Model model) {
        List<Cart> carts = cartRepository.findAll();
        int total = 0;
        for (Cart cart : carts) {
            total += cart.getTotalPrice();
        }
        model.addAttribute("total", total);
        model.addAttribute("carts", carts);
        return "cart";
    }

    // xoá sản phẩm trong giỏ hàng
    @RequestMapping("/deletecart/{id}")
    public String deleteProductInCart(@PathVariable("id") Long id, Model model) {
        cartRepository.deleteById(id);
        return "redirect:/cart";
    }

}
