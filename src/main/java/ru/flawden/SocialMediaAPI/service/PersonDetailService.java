package ru.flawden.SocialMediaAPI.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.flawden.SocialMediaAPI.entity.Person;
import ru.flawden.SocialMediaAPI.repository.PersonRepository;
import ru.flawden.SocialMediaAPI.security.PersonDetails;

import java.util.Optional;

@Component
public class PersonDetailService implements UserDetailsService {

    private PersonRepository personRepository;

    public PersonDetailService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         Optional<Person> person = personRepository.findByEmail(username);
         if(person.isEmpty()) {
             throw new UsernameNotFoundException("User not found");
         }

         return new PersonDetails(person.get());
    }

}
