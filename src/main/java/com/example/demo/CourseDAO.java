package com.example.demo;


import java.util.List;
import java.util.Optional;

public interface CourseDAO{

    List<Course> getAllCourses();
    Optional<Course> getCourseDetails(String id);
    Course createCourse(Course course);
    Course updateCourse(String id , Course course);
    Course deleteCourse(String id);
}
