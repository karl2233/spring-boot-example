package com.in28minutes.springboot.learnspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CurrencyServiceConfiguration configuration;
   @RequestMapping("/courses")
    public CurrencyServiceConfiguration retrieveAllCourses(){
        return configuration;
    }
}
