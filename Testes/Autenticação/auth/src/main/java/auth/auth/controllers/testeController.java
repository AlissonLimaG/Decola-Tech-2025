package auth.auth.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import auth.auth.model.UserModel;
import auth.auth.repository.UserRepository;

@RestController
public class testeController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String free(){
        return "BEM VINDO A RODA BASE";
    }

    @GetMapping("/tudo")
    public List<UserModel> allUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/login")
    public String login(){
        return "BEM VINDO A ROTA LOGIN";
    }   

    @GetMapping("/user")
    public String autenticado(){
        return "BEM VINDO A ROTA Autenticado";
    }    
    
    @GetMapping("/admin")
    public String admin(){
        return "BEM VINDO A ROTA ADMIN";
    }
}
