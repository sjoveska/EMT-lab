package com.example.emt.labs.service.implementation;

import com.example.emt.labs.model.Country;
import com.example.emt.labs.repository.CountryRepository;
import com.example.emt.labs.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);

    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll() ;
    }

    @Override
    public Optional<Country> save(String name, String continent) {
        Country country=new Country(name,continent);
        return Optional.of(this.countryRepository.save(country));
    }

    @Override
    public void deleteById(Long id) {
        this.countryRepository.deleteById(id);

    }
}
