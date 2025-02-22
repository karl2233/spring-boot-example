package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
@GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
    return new PersonV1("Bob Charlie");
}

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2(new Name("Bob","Charlie"));
    }

    @GetMapping(path="/person",params="version=1")//http://localhost:8080/person?version=1
    public PersonV1 getFirstVersionOfPersonRequestParameter(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path="/person",params="version=2")//http://localhost:8080/person?version=2
    public PersonV2 getSecondVersionOfPersonRequestParameter(){
        return new PersonV2(new Name("Bob","charlie"));
    }

    @GetMapping(path="/person/header",headers="X-API-VERSION=1")//add header with value 1
    public PersonV1 getFirstVersionOfPersonHeader(){
        return new PersonV1("Bob Charlie");
    }
}
