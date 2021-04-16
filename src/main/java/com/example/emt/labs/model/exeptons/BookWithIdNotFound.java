package com.example.emt.labs.model.exeptons;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BookWithIdNotFound  extends RuntimeException{
    public BookWithIdNotFound(Long id) {
        super(String.format("Book with id: %d is not found", id));
    }
}
