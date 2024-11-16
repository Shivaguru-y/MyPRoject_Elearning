package com.e.learning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.e.learning.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM Course cs WHERE stackId = :stackId")
    List<Course> getCoursesByStackId(@Param("stackId") Long stackId);
    

    
}
