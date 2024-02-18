package com.example.demo.service;

import com.example.demo.entity.Apartment;
import com.example.demo.repository.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentService {
    private final ApartmentRepository repository;

    @Autowired
    public ApartmentService(ApartmentRepository repository) {
        this.repository = repository;
    }

    public List<Apartment> getApartments() {
        return repository.findAll();
    }
    public void addNewApartment(Apartment apartment) {
        repository.save(apartment);
    }

    public void deleteApartment(Long Id) {
        boolean exists = repository.existsById(Id);
        if(!exists){
            throw new IllegalStateException("Apartment with Id "+Id+" doesn't exists");
        }
      repository.deleteById(Id);
    }
}
