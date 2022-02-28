package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseDAOImplementation implements CourseDAO{

    @Autowired
    private CourseRepository repository;

    @Override
    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    @Override
    public Optional<Course> getCourseDetails(String id) {
        long ID;
        ID = Long.parseLong(id);
        return repository.findById(ID);
    }

    @Override
    public Course createCourse(Course course) {
        return repository.save(course);
    }

    @Override
    public Course updateCourse(String id, Course course) {
        return repository.save(course);
    }

    @Override
    public Course deleteCourse(String id) {
        long ID;
        ID = Long.parseLong(id);
        repository.deleteById(ID);
        return null;
    }
}
