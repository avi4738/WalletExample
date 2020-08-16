package com.example.novopay.controller;

import com.example.novopay.model.User;
import com.example.novopay.service.UserService;
import com.example.novopay.utils.PayResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/login")
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public PayResponse signUp(@RequestBody User user){
        return userService.signUp(user);
    }

    @PostMapping("/signin")
    public PayResponse signIn(@RequestBody User user){
        return userService.signIn(user);
    }
}
