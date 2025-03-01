package auth.auth.init;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import auth.auth.model.RoleModel;
import auth.auth.model.UserModel;
import auth.auth.repository.RoleRepository;
import auth.auth.repository.UserRepository;
import jakarta.transaction.Transactional;

@Configuration
public class InitApp implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Transactional
    public void run(String... args) throws Exception {
        RoleModel role1 = new RoleModel(null, "ADMIN");
        RoleModel role2 = new RoleModel(null, "USER");
        roleRepository.saveAll(List.of(role1, role2));

        UserModel us1 = new UserModel();
        us1.setName("Alisson");
        us1.setUsername("AlissonLima");
        us1.setPassword("12345678");
        us1.getRoles().add(role2);

        UserModel us2 = new UserModel();
        us2.setName("ADMIN");
        us2.setUsername("ADMIN");
        us2.setPassword("12345678910");
        us2.getRoles().add(role1);

        userRepository.saveAll(List.of(us1, us2));
    }

}
