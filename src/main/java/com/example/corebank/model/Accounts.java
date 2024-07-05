package com.example.corebank.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jdk.jshell.Snippet;
import lombok.*;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.UUID;

@Entity
@Table(name = "ACCOUNTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Accounts {
    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID account_id;

    @Column
    @NotBlank(message = "Enter a name")
    private String name;

    @Column
    @NonNull
    private BigDecimal balance ;
    @Column
    @NonNull
    private Currency currency;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountStatus accountStatus;
    @ManyToOne
    @JoinColumn(referencedColumnName = "user_id")
    private User user;

}
