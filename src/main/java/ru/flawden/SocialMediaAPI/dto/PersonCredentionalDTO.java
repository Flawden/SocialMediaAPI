package ru.flawden.SocialMediaAPI.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PersonCredentionalDTO {

    @Email(message = "Email address entered incorrectly")
    @NotEmpty(message = "Email shouldn't be empty")
    private String email;

    @NotEmpty(message = "Password shouldn't be empty")
    private String password;

    @Size(min = 2, max = 15, message = "Firstname should be between 2 and 30 characters")
    @Pattern(regexp = "[A-Za-z]+", message = "Firstname must contain only Latin letters")
    @NotEmpty(message = "Firstname shouldn't be empty")
    private String firstName;

    @Size(min = 2, max = 15, message = "Surname should be between 2 and 30 characters")
    @Pattern(regexp = "[A-Za-z]+", message = "Surname must contain only Latin letters")
    @NotEmpty(message = "Lastname shouldn't be empty")
    private String lastName;

}
