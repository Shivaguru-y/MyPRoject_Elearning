package com.e.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e.learning.model.Admin;


import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    // Custom query to find an admin by email and password
    Optional<Admin> findByEmailAndPassword(String email, String password);

    Optional<Admin>findByEmail(String email);
}
