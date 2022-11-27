package coursework.ecomarket.controllers;

import coursework.ecomarket.entities.Products;
import coursework.ecomarket.repositories.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/productsAdmin")
//@PreAuthorize("hasAuthority('ADMIN')")
public class ProductsAdminController {

    @Autowired
    private ProductsRepo productsRepository;

    @GetMapping
    public String productsAdminList(Model model) {
        Iterable<Products> productsAdmin;
        productsAdmin = productsRepository.findAll();
        model.addAttribute("products", productsAdmin);
        return "good-list";
    }

    @GetMapping("{productsAdmin}")
    public String productsAdminEditForm(@PathVariable Products productsAdmin, Model model) {
        model.addAttribute("products", productsAdmin);
        return "good-edit";
    }

    @GetMapping("/new")
    public String productsAdminNewForm(Model model) {
        return "good-new";
    }

    @PostMapping("/new")
    public String productsAdminNewForm(@RequestParam Map<String, String> form, Products productsAdmin, Map<String, Object> model) {
        productsAdmin.setActive(true);
        productsRepository.save(productsAdmin);
        return "redirect:/productsAdmin";
    }

    @PostMapping
    public String productsAdminSave(@RequestParam("productsId") Products productsAdmin, Products productsAdmin_new, @RequestParam Map<String, String> form) {
        productsAdmin.setName(productsAdmin_new.getName());
        productsAdmin.setPrice(productsAdmin_new.getPrice());
        if (form.get("active") != null && form.get("active").equals("on")){
            productsAdmin.setActive(true);
        } else {
            productsAdmin.setActive(false);
        }
        productsRepository.save(productsAdmin);
        return "redirect:/productsAdmin";
    }
}
