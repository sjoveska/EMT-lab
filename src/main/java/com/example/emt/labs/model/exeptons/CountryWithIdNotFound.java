package com.example.emt.labs.model.exeptons;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CountryWithIdNotFound extends RuntimeException{
    public CountryWithIdNotFound(Long id) {
        super(String.format("Country with id: %d is not found", id));
    }
}
