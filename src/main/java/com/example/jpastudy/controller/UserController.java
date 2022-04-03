package com.example.jpastudy.controller;

import com.example.jpastudy.domain.user.User;
import com.example.jpastudy.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userServiceImpl")
    UserService userService;

    @PostMapping("/")
    public ResponseEntity createUser(@RequestBody User user){
        userService.createUser(user);
        return new ResponseEntity("ok", HttpStatus.CREATED);
    }
}
