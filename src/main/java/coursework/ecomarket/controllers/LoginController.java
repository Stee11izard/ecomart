package coursework.ecomarket.controllers;

import javax.transaction.Transactional;

import coursework.ecomarket.entities.Roles;
import coursework.ecomarket.repositories.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import coursework.ecomarket.entities.Client;
import coursework.ecomarket.services.UserDetailServiceImpl;

import java.util.Collection;
import java.util.Collections;

@Controller
@Transactional
public class LoginController {
    @Autowired
    UserDetailServiceImpl uService;

    @Autowired
    private ClientRepo clientRepository;
    
    @GetMapping("/registration") 
    public String Registration() {
        return "registrationForm.html";
    }

    @PostMapping("/registration")
    public String newClient(Model model, @RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("email") String email, @RequestParam("username") String username, @RequestParam("password") String password) {
        Client client = new Client(name, surname, email, username, password);
        if (username.equals("ADMIN")){
            client.setRoles(Collections.singleton(Roles.ADMIN));
        } else client.setRoles(Collections.singleton(Roles.USER));
        uService.saveClient(client);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String Login(Model model) {
        return "loginForm.html";
    }
}
