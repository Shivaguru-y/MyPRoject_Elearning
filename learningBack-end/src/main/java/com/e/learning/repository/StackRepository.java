package com.e.learning.repository;


import com.e.learning.model.Stack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StackRepository extends JpaRepository<Stack,Long>{
 
}