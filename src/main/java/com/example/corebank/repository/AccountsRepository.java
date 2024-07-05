package com.example.corebank.repository;

import com.example.corebank.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts , UUID> {

}
