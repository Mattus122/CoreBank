package com.example.corebank.service;

import com.example.corebank.dto.AccountsRegisterRequest;
import com.example.corebank.model.AccountStatus;
import com.example.corebank.model.Accounts;
import com.example.corebank.model.User;
import com.example.corebank.repository.AccountsRepository;
import com.example.corebank.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final UserRepository userRepository;
    private final AccountsRepository accountsRepository;

    public ResponseEntity<String> createaccount(UUID userId, AccountsRegisterRequest accountsRegisterRequest) {
        Optional<User> findbyid = userRepository.findById(userId);
        User user = null;
        if (findbyid.isPresent()) {
            user = findbyid.get();
        }
        if (findbyid.isPresent()) {
            Accounts accounts = Accounts.builder().name(accountsRegisterRequest.getName())
                    .balance(accountsRegisterRequest.getBalance()).
                    currency(accountsRegisterRequest.getCurrency()).
                    accountStatus(accountsRegisterRequest.getAccountStatus())
                    .user(user)
                    .build();
            Accounts newaccounts = accountsRepository.save(accounts);
            return new ResponseEntity<>("Account created at id " + newaccounts.getAccount_id(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("User cannot be found for " + userId, HttpStatus.BAD_REQUEST);
        }
    }


    public List<AccountsRegisterRequest> accountInformation(UUID userId) throws AccountNotFoundException {
//        List<Accounts> accountsList = new ArrayList<>();
////        userRepository.findAll().forEach(user -> {
////            if (user.getId().equals(userId)) {
////                accountsList.add(userRepository.fi);
////            }
////        });
//        Optional<User> userOptional = userRepository.findById(userId);
//        if (userOptional.isPresent()) {
//            accountsList = accountsRepository.findByUserId(userId);
//
//            return new ResponseEntity<>(accountsList , HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(accountsList , HttpStatus.NO_CONTENT);
//        }

        //working code incase off returning List<Accounts>>
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            List<Accounts> accounts =userOptional.get().getAccounts();
            return accounts.stream()
                    .map(account -> {
                        AccountsRegisterRequest accountDto = new AccountsRegisterRequest();
                        accountDto.setName(account.getName());
                        accountDto.setAccountStatus(account.getAccountStatus());
                        accountDto.setBalance(account.getBalance());
                        accountDto.setCurrency(account.getCurrency());
                        return accountDto;
                    })
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }
}
