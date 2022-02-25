package com.example.demo;

import org.springframework.http.HttpStatus;

import java.util.List;

public interface CourseService{

    List<Course> getAllCourses();
    Course getCourseDetails(String id);
    Course createCourse(Course course);
    Course updateCourse(String id , Course course);
    HttpStatus deleteCourse(String id);

}
