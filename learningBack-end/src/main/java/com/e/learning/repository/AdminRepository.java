package com.e.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.e.learning.model.Admin;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    // Custom query to find an admin by email and password
    @Query(nativeQuery = true, value = "SELECT * FROM Admin WHERE (email = :email AND password = :password) OR (username = :email AND password = :password)")
    Optional<Admin> findByEmailorNameAndPassword(@Param("email") String email, @Param("password") String password);

    Optional<Admin>findByEmail(String email);
}
