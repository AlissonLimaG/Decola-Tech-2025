package auth.auth.configs.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import auth.auth.model.UserModel;
import auth.auth.repository.UserRepository;

@Service
public class UserDetailsDatabase implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    public UserDetailsDatabase() {
        System.out.println("UserDetailsDatabase carregado!");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("CHEGOU");
        UserModel user = userRepository.findByUsername(username);
        
        if(user != null) System.out.println("ACHOU");
        if(user == null) throw new UsernameNotFoundException(username);
        System.out.println(username);
        System.out.println(user.getPassword());
        return user;
    }
}
