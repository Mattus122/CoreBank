package com.example.corebank.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jdk.jshell.Snippet;
import lombok.*;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID account_id;

    @Column
    @NotBlank(message = "Enter a name")
    private String name;

    @Column
    @NonNull
    private BigDecimal balance ;
    @Column
    @NonNull
    private String currency;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountStatus accountStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
//    @OneToOne 
//    @JoinColumn(name = "user_id") with the help of this we can name our foreign key and gives info regarding column we are joining.
    private User user;
    @OneToMany(mappedBy = "accounts" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private List<Transaction> transaction;

}
