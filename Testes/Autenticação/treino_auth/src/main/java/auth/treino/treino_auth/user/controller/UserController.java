package auth.treino.treino_auth.user.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import auth.treino.treino_auth.infra.security.TokenService;
import auth.treino.treino_auth.user.DTO.LoginResponseDTO;
import auth.treino.treino_auth.user.DTO.UserLoginDTO;
import auth.treino.treino_auth.user.model.UserModel;
import auth.treino.treino_auth.user.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<UserModel> save(@RequestBody UserModel user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return ResponseEntity.ok().body(userService.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginDTO userLoginDTO){
        var usernamePassword = new UsernamePasswordAuthenticationToken(userLoginDTO.username(), userLoginDTO.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((UserModel)auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @GetMapping("/tudo")
    public ResponseEntity<List<UserModel>> findAll(){
        return ResponseEntity.ok().body(userService.findAll());
    }


}
