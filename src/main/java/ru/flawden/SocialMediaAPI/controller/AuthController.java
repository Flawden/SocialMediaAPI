package ru.flawden.SocialMediaAPI.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.flawden.SocialMediaAPI.dto.PersonCredentionalDTO;
import ru.flawden.SocialMediaAPI.entity.Person;
import ru.flawden.SocialMediaAPI.exception.ValidationException;
import ru.flawden.SocialMediaAPI.service.PersonService;
import ru.flawden.SocialMediaAPI.util.PersonValidator;

@RestController
@RequestMapping("/api/v1/person")
public class AuthController {

    private PersonService personService;
    private ModelMapper modelMapper;

    private PersonValidator personValidator;

    public AuthController(PersonService personService, PersonValidator personValidator) {
        this.personService = personService;
        this.personValidator = personValidator;
        this.modelMapper = new ModelMapper();
    }

    @PostMapping
    public ResponseEntity addPerson(@RequestBody @Valid PersonCredentionalDTO personCredentional, BindingResult bindingResult) {
        Person person = modelMapper.map(personCredentional, Person.class);
        personValidator.validate(person, bindingResult);
        if(bindingResult.hasErrors()) {
            StringBuilder error = new StringBuilder();
            bindingResult.getFieldErrors().forEach(a -> error.append(a.getDefaultMessage() + "; "));
            throw new ValidationException(error.toString());
        }
        personService.registration(person);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/bla")
    public String bla() {
        return "bla";
    }

    @ExceptionHandler(ValidationException.class)
    private String exception(HttpServletRequest request, Exception exception) {
        return exception.getMessage();
    }

}
