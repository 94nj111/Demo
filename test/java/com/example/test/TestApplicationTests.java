package com.example.test;

import com.example.test.model.Person;
import com.example.test.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestApplicationTests {

    @Autowired
    private PersonRepository personRepository;


    @Test
    public void createReadTest(){
        Person person = new Person("Name", "Surname", new Date());
        personRepository.save(person);
        Long id = person.getId();

        Person other = personRepository.findById(id).orElse(null);

        assertNotNull(other);
        assertEquals(person.getName(), other.getName());
        assertEquals(person.getSurname(), other.getSurname());
        assertEquals(person.getDateOfBirth(), other.getDateOfBirth());
    }



    @Test
    public void deleteTest(){
        Person person = new Person("Name", "Surname", new Date());
        personRepository.save(person);

        personRepository.deleteAll();

        List<Person> people = personRepository.findAll();
        assertTrue(people.isEmpty());
    }
}
