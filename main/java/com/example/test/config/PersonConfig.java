package com.example.test.config;

import com.example.test.model.Person;
import com.example.test.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.Random;

@Configuration
public class PersonConfig {

    @Bean
    public CommandLineRunner demo(final PersonService personService){
        return strings -> {
            Person person;
            Random rn = new Random();
          for(int i = 0; i < 20; i++){
              person = new Person("Name" + i, "Surname" + i, new Date(rn.nextLong(0, new Date().getTime())));
              personService.save(person);
          }
        };
    }
}
