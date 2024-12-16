package dev.kyky.NR.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NinjaNotFoundException extends RuntimeException {

    public NinjaNotFoundException() {
        super("Ninja not found.");
    }

}
