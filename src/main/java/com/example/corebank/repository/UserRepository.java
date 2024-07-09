package com.example.corebank.repository;

import com.example.corebank.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository <User , UUID>{
    @EntityGraph(attributePaths = "accounts")
    Optional<User> findById(UUID id);
}
