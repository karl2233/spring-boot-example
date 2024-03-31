package com.in28minutes.rest.webservices.restfulwebservices.user;

import com.in28minutes.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {
private UserDaoService service;

public UserResource(UserDaoService service){
    this.service = service;
}
@GetMapping("/users")
public List<User> retrieveAllUser(){
    return service.findAll();
}

@GetMapping("/users/{id}")
 public User retrieveUser(@PathVariable int id){
   // User user = service.findOne(id);
    //if(user == null){
        throw new UserNotFoundException("id: "+id);
    //}
    //return service.findOne(id);
}

@PostMapping("/users")
    public void createUser(@Valid @RequestBody User user){
    service.save(user);
}
}
