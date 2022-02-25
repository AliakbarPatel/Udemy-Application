package com.example.demo;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CourseController{

    @Autowired
    public CourseServiceImplementation courseServiceImplementation;

    // http://localhost:8080/courses
    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseServiceImplementation.getAllCourses();
    }

    // http://localhost:8080/courses/1
    @GetMapping("/courses/{id}")
    public Course getCourseDetails(@PathVariable String id) {
        return courseServiceImplementation.getCourseDetails(id);
    }



    //POST - Create a new resource (/courses)
    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course) {
        return courseServiceImplementation.createCourse(course);
    }



    //PUT - Update/Replace a resource (/courses/1)
    @PutMapping("/courses/{id}")
    public Course updateCourse(@PathVariable String id, @RequestBody Course course) {
        return courseServiceImplementation.updateCourse(id, course);
    }


    //DELETE - Delete a resource (/courses/1)
    @DeleteMapping("/courses/{id}")
    public HttpStatus deleteCourse(@PathVariable String id) {
        return courseServiceImplementation.deleteCourse(id);
    }

}