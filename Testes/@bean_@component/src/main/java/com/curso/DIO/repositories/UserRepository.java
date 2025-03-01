package com.curso.DIO.repositories;

import com.curso.DIO.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByIdBetween(int a, int b);
}
