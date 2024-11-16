package com.e.learning.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.e.learning.DTO.registerDTO;
import com.e.learning.model.Admin;
import com.e.learning.model.User;
import com.e.learning.repository.AdminRepository;
import com.e.learning.repository.UserRepository;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    public ResponseEntity<Map<String, String>> register(registerDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);
        Map<String, String> response = new HashMap<>();
        if (user.getUserId() != null) {
            response.put("message", "User saved successfully");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "User save failed");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public Object authenticate(String email, String password) {
        // Check if the user is in the User table
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getPassword().equals(password)) {
                return user; // Redirect to user dashboard
            } else {
                throw new RuntimeException("Invalid password");
            }
        }

        // If not a user, check the Admin table
        Optional<Admin> optionalAdmin = adminRepository.findByEmail(email);
        if (optionalAdmin.isPresent()) {
            Admin admin = optionalAdmin.get();
            if (admin.getPassword().equals(password)) {
                return admin; // Redirect to admin dashboard
            } else {
                throw new RuntimeException("Invalid password");
            }
        }

        // If neither found, throw an exception
        throw new RuntimeException("User or Admin not found");
    }
}
