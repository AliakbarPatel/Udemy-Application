package com.example.demo;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
    private CourseRepository repository;


    // http://localhost:8080/courses
    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    // http://localhost:8080/courses/1
    @GetMapping("/courses/{id}")
    public Course getCourseDetails(@PathVariable String id) {
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



    //POST - Create a new resource (/courses)
    @PostMapping("/courses")
    public void createCourse(@RequestBody Course course) {
        repository.save(course);
    }



    //PUT - Update/Replace a resource (/courses/1)
    @PutMapping("/courses/{id}")
    public void updateCourse(@PathVariable String id, @RequestBody Course course) {
        Long ID = 0L;
        try{
            ID = Long.parseLong(id);
        }
        catch (Exception e){ throw new RuntimeException("Invalid input, added value is a String please enter a positive integer");}
        course.setId(ID);
        if(ID<=0)
            throw new RuntimeException("Invalid address, please enter positive integer");
        try {
            if (getCourseDetails(id) == null)
                throw new RuntimeException("Course not found with id " + id);
        } finally {
            repository.save(course);
        }

    }


    //DELETE - Delete a resource (/courses/1)
    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable String id) {
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
    }

}