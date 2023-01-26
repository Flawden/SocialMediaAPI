package ru.flawden.SocialMediaAPI.service;

import org.springframework.stereotype.Service;
import ru.flawden.SocialMediaAPI.entity.Person;
import ru.flawden.SocialMediaAPI.repository.PersonRepository;

import java.util.Optional;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void registration(Person user) {
        Person person = personRepository.save(user);
    }
}
