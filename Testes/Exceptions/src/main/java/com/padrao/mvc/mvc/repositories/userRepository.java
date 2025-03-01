package com.padrao.mvc.mvc.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.padrao.mvc.mvc.models.user.User;

public interface userRepository extends JpaRepository<User,Long>{}
