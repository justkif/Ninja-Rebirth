package dev.kyky.NR.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UserUnauthorizedException extends RuntimeException {

    public UserUnauthorizedException() {
        super("Incorrect username or password.");
    }

}
