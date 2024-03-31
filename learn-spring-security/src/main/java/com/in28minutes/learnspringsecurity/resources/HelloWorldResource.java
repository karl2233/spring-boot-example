package com.in28minutes.learnspringsecurity.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorldResource {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private static final List<Todo> TODO_LIST = List.of(new Todo("in28minutes","Lean AWS"),
            new Todo("in28minutes","Get AWS Certified"));

    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos(){
        return TODO_LIST;
    }

    @GetMapping("/users/{username}/todos")
    public Todo retrieveTodosForSpecificUser(@PathVariable String username){
        return TODO_LIST.get(0);
    }

    @PostMapping("/users/{username}/todos")
    public Todo createTodoForSpecificUser(@PathVariable String username ,@RequestBody Todo todo){
        logger.info("Create{} for {}",todo,username);
        return todo;
    }
}
record Todo(String username,String description){

}
