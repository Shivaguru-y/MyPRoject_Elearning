package com.e.learning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.e.learning.model.Material;


@Repository
public interface MaterialsRepository extends JpaRepository<Material, Long> {
    @Query(nativeQuery = true,value = "SELECT * from Material where courseId = :courseId")
    List<Material> getMaterialsByCourseId(@Param("courseId") long id);
    
}
