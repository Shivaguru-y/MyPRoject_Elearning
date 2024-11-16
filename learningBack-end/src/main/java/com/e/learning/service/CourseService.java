package com.e.learning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e.learning.model.Course;
import com.e.learning.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public List<Course> getCoursesByStackId(Long stackId) {
        return courseRepository.getCoursesByStackId(stackId);
    }
    
    
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Long courseId, Course courseDetails) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found for this id :: " + courseId));

        course.setCourseName(courseDetails.getCourseName());
        course.setDescription(courseDetails.getDescription());
        course.setStack(courseDetails.getStack());
        course.setMaterials(courseDetails.getMaterials());
        course.setFeedbacks(courseDetails.getFeedbacks());
        course.setUserCourses(courseDetails.getUserCourses());

        return courseRepository.save(course);
    }

    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }
}
