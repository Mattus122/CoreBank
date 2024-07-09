package com.example.corebank.model;

import jakarta.persistence.*;

import java.util.UUID;


@Entity
@Table(name = "Transaction")
public class Transaction {
    @Id
    @Column(name = "" )
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID transactionId;
    @Column
    private String type;
    @Column
    private String status;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Accounts accounts;

}
