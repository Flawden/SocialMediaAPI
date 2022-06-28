package ru.flawden.SocialMediaAPI.util;

import org.springframework.stereotype.Component;
import ru.flawden.SocialMediaAPI.exception.ValidationException;

@Component
public class ValidationUtil {

    public void validateEmail(String email) {
        String pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if (!email.matches(pattern)) {
            throw new ValidationException("Illegal email");
        }
    }

    public void validatePhoneNumber(String number) {
        String pattern = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
        if (!number.matches(pattern)) {
            throw new RuntimeException("Illegal phone number");
        }
    }

}
