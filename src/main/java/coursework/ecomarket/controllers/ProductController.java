package coursework.ecomarket.controllers;

import coursework.ecomarket.entities.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import coursework.ecomarket.services.ProductsService;

import java.util.Map;

@Controller
public class ProductController {
    @Autowired
    ProductsService pService;
    
    @GetMapping("/catalog") 
    public String Catalog(Model model, @RequestParam(name = "category", required = false) String category) {
        model.addAttribute("products", pService.showByCategory(category));
        return "catalog";
    }
    @GetMapping("/product")
    public String ProductPage(Model model, @RequestParam(name="id", required = false) int id) {
        model.addAttribute("product", pService.findById(id));
        return "productPage.html";
    }
}
