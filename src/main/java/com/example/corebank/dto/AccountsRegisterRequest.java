package com.example.corebank.dto;

import com.example.corebank.model.AccountStatus;

import java.math.BigDecimal;
import java.util.BitSet;
import java.util.Currency;

public class AccountsRegisterRequest {
    private String name;
    private BigDecimal balance;
    private Currency currency;
    private AccountStatus accountStatus;
}
