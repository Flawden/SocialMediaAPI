package ru.flawden.SocialMediaAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {super();}
    public UserNotFoundException(String message) {
        super(message);
    }

}
