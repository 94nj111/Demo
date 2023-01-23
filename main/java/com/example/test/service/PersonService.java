package com.example.test.service;

import com.example.test.model.Person;
import com.example.test.repository.PersonRepository;
import org.springframework.stereotype.Service;


@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void save(Person person){
        personRepository.save(person);
    }

    public Person getById(Long id){
        return personRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id){
        personRepository.deleteById(id);
    }
}
