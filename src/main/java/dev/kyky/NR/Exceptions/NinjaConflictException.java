package dev.kyky.NR.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class NinjaConflictException extends RuntimeException {

    public NinjaConflictException() {
        super("Ninja existed.");
    }

}
