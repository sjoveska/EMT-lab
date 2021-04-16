package com.example.emt.labs.model.exeptons;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AuthorWithIdNotFound extends RuntimeException{
    public AuthorWithIdNotFound(Long id) {
        super(String.format("Author with id: %d is not found", id));
    }
}
