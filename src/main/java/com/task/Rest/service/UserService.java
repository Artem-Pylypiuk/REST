package com.task.Rest.service;

import com.task.Rest.DTO.UserLoginDTO;
import com.task.Rest.DTO.UserRegistrationDTO;
import com.task.Rest.model.User;
import com.task.Rest.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public User register(UserRegistrationDTO userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userRepo.save(user);
    }

    public String login(UserLoginDTO userDto) {
        Optional<User> userOpt = userRepo.findByEmail(userDto.getEmail());
        if (userOpt.isPresent() && passwordEncoder.matches(userDto.getPassword(), userOpt.get().getPassword())) {
            return jwtService.generateToken(userOpt.get());
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }

}
