package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImplementation implements CourseService{

    @Autowired
    private CourseRepository repository;

    @Override
    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    @Override
    public Course getCourseDetails(String id) {
        Long ID = 0L;
        try{
            ID = Long.parseLong(id);
        }
        catch (Exception e){ throw new RuntimeException("Invalid input, added value is a String please enter a positive integer");}

        Optional<Course> course = repository.findById(ID);

        if(ID<=0)
            throw new RuntimeException("Invalid address, please enter positive integer");
        else if (course.isPresent())
            return course.get();
        else
            throw new RuntimeException("Course not found with id " + id);
    }

    @Override
    public Course createCourse(Course course) {
        return  repository.save(course);
    }

    @Override
    public Course updateCourse(String id, Course course) {
        Long ID = 0L;
        try{
            ID = Long.parseLong(id);
        }
        catch (Exception e){ throw new RuntimeException("Invalid input, added value is a String please enter a positive integer");}
       course.setId(ID);
        if(ID<=0)
            throw new RuntimeException("Invalid address, please enter positive integer");
        else if (getCourseDetails(id) == null)
            throw new RuntimeException("Course not found with id " + id);
        else return repository.save(course);
    }

    @Override
    public HttpStatus deleteCourse(String id) {
        Long ID = 0L;
        try{
            ID = Long.parseLong(id);
        }
        catch (Exception e){ throw new RuntimeException("Invalid input, added value is a String please enter a positive integer");}
        if(ID<=0)
            throw new RuntimeException("Invalid address, please enter positive integer");
        try {
            if (getCourseDetails(id) == null)
                throw new RuntimeException("Course not found with id " + id);
        }

        catch (EmptyResultDataAccessException e){}
        repository.deleteById(ID);
        return HttpStatus.OK;
    }

}
