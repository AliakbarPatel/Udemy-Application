package com.example.demo;


import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="course_name")
    private String name;

    private String author;

    private String publishedOn;

    private String courseDescription;

    public Course() {
    }

    public Course(long id, String name, String author, String publishedOn, String courseDescription) {
        super();
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishedOn = publishedOn;
        this.courseDescription = courseDescription;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishedOn() {return publishedOn;}

    public String getCourseDescription() {
        return courseDescription;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", name=" + name + ", author=" + author + ", publishedOn=" + publishedOn +", " +
                "courseDescription=" + courseDescription +"]";
    }


    public void setId(long id) { this.id = id;
    }

}