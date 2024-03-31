package com.in28minutes.spring.boot.learnjpaandhibernate.course.jpa;

import com.in28minutes.spring.boot.learnjpaandhibernate.course.Course;
import com.in28minutes.spring.boot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJpaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    public void insert(Course course){
        entityManager.merge(course);
    }

    public Course update(Course course){
        return entityManager.merge(course);
    }

    public Course findById(long id){
        return entityManager.find(Course.class,id);
    }

    public void deleteById(long id){
        Course course = entityManager.find(Course.class,id);
        entityManager.remove(course);
    }
}
