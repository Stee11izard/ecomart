package coursework.ecomarket.controllers;

import coursework.ecomarket.entities.Products;
import coursework.ecomarket.repositories.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/productsAdmin")
@PreAuthorize("hasAuthority('ADMIN')")
public class ProductsAdminController {

    @Autowired
    private ProductsRepo productsRepository;

    @GetMapping
    public String productsAdminList(Model model) {
        Iterable<Products> productsAdmin;
        productsAdmin = productsRepository.findAll();
        model.addAttribute("products", productsAdmin);
        return "products-list";
    }

    @GetMapping("{productsAdmin}")
    public String productsAdminEditForm(@PathVariable Products productsAdmin, Model model) {
        model.addAttribute("products", productsAdmin);
        return "products-edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        Products product = productsRepository.findById(id);
        productsRepository.delete(product);
        return "redirect:/productsAdmin";
    }

    @GetMapping("/new")
    public String productsAdminNewForm(Model model) {
        return "products-new";
    }

    @PostMapping("/new")
    public String productsAdminNewForm(@RequestParam Map<String, String> form, Products productsAdmin, Map<String, Object> model) {
        productsRepository.save(productsAdmin);
        return "redirect:/productsAdmin";
    }

    @PostMapping
    public String productsAdminSave(@RequestParam("productsId") Products productsAdmin, Products productsAdmin_new, @RequestParam Map<String, String> form) {
        productsAdmin.setName(productsAdmin_new.getName());
        productsAdmin.setCategory(productsAdmin_new.getCategory());
        productsAdmin.setDiscription(productsAdmin_new.getDiscription());
        productsAdmin.setPrice(productsAdmin_new.getPrice());
        productsRepository.save(productsAdmin);
        return "redirect:/productsAdmin";
    }
}
