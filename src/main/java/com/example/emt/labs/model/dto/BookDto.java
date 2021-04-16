package com.example.emt.labs.model.dto;

import com.example.emt.labs.model.Author;
import com.example.emt.labs.model.enumerations.Category;
import lombok.Data;


@Data
public class BookDto {
    private String name;
    private Category category;
    private Long authorid;
    private Integer availableCopies;

    public BookDto(String name, Category category, Long authorid, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.authorid = authorid;
        this.availableCopies = availableCopies;
    }
}
