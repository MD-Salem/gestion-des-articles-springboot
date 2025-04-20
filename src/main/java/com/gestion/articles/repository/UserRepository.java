package com.gestion.articles.repository;

import com.gestion.articles.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
}
