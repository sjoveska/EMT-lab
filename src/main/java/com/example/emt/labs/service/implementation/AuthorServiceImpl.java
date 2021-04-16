package com.example.emt.labs.service.implementation;

import com.example.emt.labs.model.Author;
import com.example.emt.labs.model.Country;
import com.example.emt.labs.model.exeptons.CountryWithIdNotFound;
import com.example.emt.labs.repository.AuthorRepository;
import com.example.emt.labs.repository.CountryRepository;
import com.example.emt.labs.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> save(String name, String surname, Long country) {
        Country country1=this.countryRepository.findById(country).orElseThrow(()->new CountryWithIdNotFound(country));
        Author author=new Author(name,surname,country1);
        return Optional.of(this.authorRepository.save(author));
    }

    @Override
    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);

    }
}
