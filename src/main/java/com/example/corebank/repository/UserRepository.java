package com.example.corebank.repository;

import com.example.corebank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository <User , UUID>{

}
