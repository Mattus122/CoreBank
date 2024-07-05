package com.example.corebank.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.NumberFormat;

import java.util.UUID;

@Entity
@Table(name = "USERS")
@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID id;
    @NotBlank(message = "Provide a name")
    @Column(name = "user_name")
    private String name;
    @Positive
    @Digits(fraction = 0, integer = 10, message ="add a digit msg")
//    @Min(value = 0, message = "Age should not be less than 0")
//    @Max(value = 150, message = "Age should not be greater than 150")
    @Column(name = "user_age")
    private Integer age;



}
