package com.example.test.controller;

import com.example.test.model.Person;
import com.example.test.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public Person show(@PathVariable("id") Long id){
        return personService.getById(id);
    }
}
