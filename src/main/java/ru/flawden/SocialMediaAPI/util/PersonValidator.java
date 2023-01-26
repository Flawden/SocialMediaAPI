package ru.flawden.SocialMediaAPI.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.flawden.SocialMediaAPI.entity.Person;
import ru.flawden.SocialMediaAPI.repository.PersonRepository;

@Component
public class PersonValidator implements Validator {

    private PersonRepository personRepository;

    public PersonValidator(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if (personRepository.findByEmail(person.getEmail()).isPresent()) {
            errors.rejectValue("email", "400", "This email is already taken");
        }
    }
}
