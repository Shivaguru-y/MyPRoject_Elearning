package com.e.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e.learning.model.Course;
import com.e.learning.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/getAllCourse")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("getCoursebyStack/{id}")
    public List<Course> getCourseById(@PathVariable(value = "id") Long courseId) {
    return courseService.getCoursesByStackId(courseId);
    }


    @PostMapping("/createCourse")
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @PutMapping("/updateCourseById/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable(value = "id") Long courseId,
            @RequestBody Course courseDetails) {
        Course updatedCourse = courseService.updateCourse(courseId, courseDetails);
        return ResponseEntity.ok(updatedCourse);
    }

}
