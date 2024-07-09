package com.example.corebank.dto;

import com.example.corebank.model.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.BitSet;
import java.util.Currency;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountsRegisterRequest {
    private String name;
    private BigDecimal balance;
    private String currency;
    private AccountStatus accountStatus;
}
