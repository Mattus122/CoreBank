package com.example.corebank.controller;

import com.example.corebank.dto.AccountsRegisterRequest;
import com.example.corebank.model.Accounts;
import com.example.corebank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class AccountsController {
    private final AccountService accountService;
    @GetMapping("/{user_id}/accounts")
    List<AccountsRegisterRequest> getaccountInfo(@PathVariable UUID user_id) throws AccountNotFoundException {
        return accountService.accountInformation(user_id);
    }

    @PostMapping("/{user_id}/accounts")
    ResponseEntity<String> createanaccount(@PathVariable UUID user_id , @RequestBody AccountsRegisterRequest accountsRegisterRequest){
        return accountService.createaccount(user_id , accountsRegisterRequest);
    }
}
