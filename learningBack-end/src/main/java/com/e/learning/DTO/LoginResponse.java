package com.e.learning.DTO;

public class LoginResponse {
    private String role; // "admin" or "user"
    private Long id;

    public LoginResponse(String role, Long id) {
        this.role = role;
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   
}
