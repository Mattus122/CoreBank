package com.example.corebank.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.NumberFormat;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "USERS")
@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private UUID id;

    @Column(name = "user_name",nullable = false)
    private String name;


    @Column(name = "user_age")
    private Integer age;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @OneToOne(mappedBy = "user" , cascade = CascadeType.ALL) in one to one  mapping mappedbyuser does not create  a fk of account id in user
    //table but a bidirectional relationshp is established so u can get user from accounts and account from user.
    //cascade all helps in performing operations on child table also if there are any changes in the main table .
    private List<Accounts> accounts;

}
