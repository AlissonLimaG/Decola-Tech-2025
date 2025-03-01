package com.curso.DIO.configs;

import com.curso.DIO.entities.User;
import com.curso.DIO.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StartApp implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User us1 = new User(null,"Alisson","12345678");
        User us2 = new User(null, "Bruna", "87654321");
        User us3 = new User(null, "Carlos", "11223344");
        User us4 = new User(null, "Diana", "44332211");
        User us5 = new User(null, "Eduardo", "55667788");
        User us6 = new User(null, "Fernanda", "88776655");
        User us7 = new User(null, "Gabriel", "99887766");
        User us8 = new User(null, "Helena", "66778899");
        User us9 = new User(null, "Igor", "12344321");
        User us10 = new User(null, "Juliana", "43211234");
        User us11 = new User(null, "Kleber", "78901234");

        userRepository.saveAll(List.of(us1,us2,us3,us4,us5,us6,us7,us8,us9,us10,us11));

        List<User> ls = userRepository.findByIdBetween(2,5);

        for (User l : ls) {
            System.out.println(l);
        }
    }
}
