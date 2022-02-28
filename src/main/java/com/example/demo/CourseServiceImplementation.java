package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImplementation implements CourseService{

    @Autowired
    public CourseDAOImplementation courseDAOImplementation;


    @Override
    public List<Course> getAllCourses() {
        return courseDAOImplementation.getAllCourses();
    }

    @Override
    public Course getCourseDetails(String id) {
        long ID;
        try{
            ID = Long.parseLong(id);
        }
        catch (Exception e){ throw new RuntimeException("Invalid input, added value is a String please enter a positive integer");}

        Optional<Course> course = courseDAOImplementation.getCourseDetails(id);

        if(ID<=0)
            throw new RuntimeException("Invalid address, please enter positive integer");
        else if (course.isPresent())
            return course.get();
        else
            throw new RuntimeException("Course not found with id " + id);
    }

    @Override
    public Course createCourse(Course course) {
        return  courseDAOImplementation.createCourse(course);
    }

    @Override
    public Course updateCourse(String id, Course course) {
        long ID;
        try{
            ID = Long.parseLong(id);
        }
        catch (Exception e){ throw new RuntimeException("Invalid input, added value is a String please enter a positive integer");}
       course.setId(ID);
        if(ID<=0)
            throw new RuntimeException("Invalid address, please enter positive integer");
        else if (getCourseDetails(id) == null)
            throw new RuntimeException("Course not found with id " + id);
        else return courseDAOImplementation.updateCourse(id, course);
    }

    @Override
    public HttpStatus deleteCourse(String id) {
        long ID;
        try{
            ID = Long.parseLong(id);
        }
        catch (Exception e){ throw new RuntimeException("Invalid input, added value is a String please enter a positive integer");}
        if(ID<=0)
            throw new RuntimeException("Invalid address, please enter positive integer");

            else if (getCourseDetails(id) == null)
                throw new RuntimeException("Course not found with id " + id);

        courseDAOImplementation.deleteCourse(id);
        return HttpStatus.OK;
    }

}
