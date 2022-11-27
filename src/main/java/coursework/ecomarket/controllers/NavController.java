package coursework.ecomarket.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
    @GetMapping("/")
    public String HomePage() {
        return "index";
    }
    @GetMapping("/about")
    public String AboutPage() {
        return "aboutus";
    }
    @GetMapping("/delivery")
    public String Delivery() {
        return "delivery";
    }
    @GetMapping("/products")
    public String Products() {
        return "products";
    }
    @GetMapping("/adminProducts/new")
    public String ProductsNew() {
        return "productNew";
    }
}
