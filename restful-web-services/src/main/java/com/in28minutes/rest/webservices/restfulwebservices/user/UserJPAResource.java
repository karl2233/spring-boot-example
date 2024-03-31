package com.in28minutes.rest.webservices.restfulwebservices.user;

import com.in28minutes.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.in28minutes.rest.webservices.restfulwebservices.jpa.PostRepository;
import com.in28minutes.rest.webservices.restfulwebservices.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserJPAResource {
private UserDaoService service;
private UserRepository repository;

private PostRepository postRepository;

public UserJPAResource(UserDaoService service,UserRepository repository,PostRepository postRepository){
    this.service = service;
    this.postRepository = postRepository;
    this.repository = repository;
}

@GetMapping("/jpa/users")
public List<User> retrieveAllUser(){
    return repository.findAll();
}

@GetMapping("/jpa/users/{id}")
 public Optional<User> retrieveUser(@PathVariable int id){
    Optional<User> user = repository.findById(id);
    if(user.isEmpty()){
        throw new UserNotFoundException("id:"+id);
    }
    return user;
}

@DeleteMapping("/jpa/users/{id}")
public void deleteUser(@PathVariable int id){
    repository.deleteById(id);
}


    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrievePostsForAUser(@PathVariable int id){
        Optional<User> user = repository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id:"+id);
        }
        return user.get().getPosts();
    }

@PostMapping("/jpa/users")
    public void createUser(@Valid @RequestBody User user){
    repository.save(user);
}
}
