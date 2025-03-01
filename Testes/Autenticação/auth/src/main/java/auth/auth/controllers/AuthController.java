package auth.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import auth.auth.model.RoleModel;
import auth.auth.model.UserModel;
import auth.auth.model.dto.AuthenticationDTO;
import auth.auth.model.dto.RegisterDTO;
import auth.auth.repository.RoleRepository;
import auth.auth.repository.UserRepository;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/registrar")
    public ResponseEntity<UserModel> save(@RequestBody RegisterDTO user){
        String encryptedPassword = new BCryptPasswordEncoder().encode(user.password());
        RoleModel role = roleRepository.findByRole(user.role());
        UserModel user1 = new UserModel(user.name(),user.username(),encryptedPassword,role);

        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(user1));
    }

    @PostMapping("/login")
    public ResponseEntity login (@RequestBody AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }

}
