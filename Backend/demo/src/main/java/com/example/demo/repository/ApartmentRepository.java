package com.example.demo.repository;

import com.example.demo.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment,Long> {

    @Query("Select a from Apartment a where a.address='Peelamedu'")
    Optional<Apartment> findApartmentByAddress(String Address);
}
