
package com.e.learning.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e.learning.DTO.LoginRequest;
import com.e.learning.DTO.LoginResponse;
import com.e.learning.DTO.registerDTO;
import com.e.learning.model.Admin;
import com.e.learning.model.User;
import com.e.learning.repository.AdminRepository;
import com.e.learning.repository.UserRepository;
import com.e.learning.service.AuthService;

@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody registerDTO userRegDTO) {
        return authService.register(userRegDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        Optional<Admin> admin = adminRepository.findByEmailAndPassword(email, password);
        if (admin.isPresent()) {
            return ResponseEntity.ok(new LoginResponse("admin", admin.get().getAdminId()));
        }
        Optional<User> user = userRepository.findByEmailAndPassword(email, password);
        if (user.isPresent()) {
            return ResponseEntity.ok(new LoginResponse("user", user.get().getUserId()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

}
