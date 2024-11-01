package com.task.Rest.controller;

import com.task.Rest.DTO.UserLoginDTO;
import com.task.Rest.DTO.UserRegistrationDTO;
import com.task.Rest.model.User;
import com.task.Rest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/auth/register")
    public String register(@RequestBody UserRegistrationDTO userDto) {
        User user = userService.register(userDto);
        return "User registered successfully: " + user.getEmail();
    }

    @PostMapping("/auth/login")
    public String login(@RequestBody UserLoginDTO userDto) {
        String token = userService.login(userDto);
        return "User logged in successfully, token: " + token;
    }
}
