package com.example.corebank.service;

import com.example.corebank.dto.RegisterRequest;
import com.example.corebank.exception.AgeException;
import com.example.corebank.model.User;
import com.example.corebank.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public ResponseEntity<List<User>> returnAllUser(){
        List<User> userlist = new ArrayList<User>();
        userRepository.findAll().forEach(userlist::add);
        if(userlist.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userlist,HttpStatus.OK);

    }

    public ResponseEntity<String> add(RegisterRequest  registerRequest) throws Exception {
        if(registerRequest.getAge() <0 || registerRequest.getAge()>150){
            throw new AgeException("Enter a valid age");
        }else{
            User user = User.builder().name(registerRequest.getName()).age(registerRequest.getAge()).build();
            User savedUser = userRepository.save(user);
            return new ResponseEntity<>("User saved at ID : "+ savedUser.getId() , HttpStatus.CREATED);
        }

    }


    public ResponseEntity<User> update(User newUserData, UUID uuid) {
        if(newUserData.getAge()<0 || newUserData.getAge()>150){
            throw new AgeException("Enter a valid age"); 
        }
        Optional<User> oldUserData = userRepository.findById(uuid);
        if (oldUserData.isPresent()){
            User updateuser = oldUserData.get();
            updateuser.setName(newUserData.getName());
            updateuser.setAge(newUserData.getAge()); ;
            User obj = userRepository.save(updateuser);
            return new ResponseEntity<>(obj,HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
