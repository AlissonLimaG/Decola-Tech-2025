package auth.treino.treino_auth.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import auth.treino.treino_auth.user.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{
    UserModel findByUsername(String username);
}
