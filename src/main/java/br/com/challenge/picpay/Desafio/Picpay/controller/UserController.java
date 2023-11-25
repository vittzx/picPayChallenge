package br.com.challenge.picpay.Desafio.Picpay.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.challenge.picpay.Desafio.Picpay.domain.user.User;
import br.com.challenge.picpay.Desafio.Picpay.dto.UserDTO;
import br.com.challenge.picpay.Desafio.Picpay.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllusers(){
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<User>createUser(@RequestBody @Valid UserDTO userDTO){
        User newUser = userService.createUser(userDTO);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
