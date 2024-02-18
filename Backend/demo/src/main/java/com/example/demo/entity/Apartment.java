package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@Table(name = "Apartment")
@Data
public class Apartment {
    @Id
    @SequenceGenerator(
            name = "Apartment",
            sequenceName = "apartment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "apartment_sequence"
    )
    private Long id;
    private String name;
    private LocalDate buildOn;
    private LocalDate buildOff;

    @OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL)
    private List<House> houses;

    @Transient
    private Integer age; // Mark as transient

    private String address;
    private Integer totalHouse;
    private Integer occupied;
    private Integer unoccupied;

    public Apartment() {
    }

    public Apartment(Long id, String name, String address, Integer totalHouse, Integer occupied, Integer unoccupied, LocalDate buildOn) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.totalHouse = totalHouse;
        this.occupied = occupied;
        this.unoccupied = unoccupied;
        this.buildOn = buildOn;
        this.age = calculateAge(buildOn); // Calculate age
    }

    public Apartment(String name, String address, Integer totalHouse, Integer occupied, Integer unoccupied, LocalDate buildOn) {
        this.name = name;
        this.address = address;
        this.totalHouse = totalHouse;
        this.occupied = occupied;
        this.unoccupied = unoccupied;
        this.buildOn = buildOn;
        this.age = calculateAge(buildOn); // Calculate age
    }

    public Apartment(String name, String address, Integer totalHouse, Integer occupied, Integer unoccupied) {
        this.name = name;
        this.address = address;
        this.totalHouse = totalHouse;
        this.occupied = occupied;
        this.unoccupied = unoccupied;
    }

    // Calculate age based on buildOn date
    private Integer calculateAge(LocalDate buildOn) {
        return Period.between(buildOn, LocalDate.now()).getYears();
    }

    // Getters and setters
    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    // Other getters and setters

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", buildOn=" + buildOn +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", totalHouse=" + totalHouse +
                ", occupied=" + occupied +
                ", unoccupied=" + unoccupied +
                '}';
    }
}
