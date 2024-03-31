package com.in28minutes.spring.boot.learnjpaandhibernate.course.springdatajpa;

import com.in28minutes.spring.boot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JpaImpl {
    @Autowired
    private CourseSpringDataJpaRepository repository;

    public void run(){
        repository.save(new Course(2,"",""));
        repository.deleteById(1l);
        System.out.println(repository.findById(2l));
        System.out.println(repository.findAll());
        System.out.println(repository.count());
        System.out.println(repository.findByAuthor("in28minutes"));

    }
}
