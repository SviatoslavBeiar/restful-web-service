package com.in.rest.webservices.resfulwebservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundExpetion extends RuntimeException {
    public UserNotFoundExpetion(String message) {
        super(message);
    }
}
