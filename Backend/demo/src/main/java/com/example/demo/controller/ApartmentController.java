package com.example.demo.controller;

import java.util.*;

import com.example.demo.dto.HouseReqDto;
import com.example.demo.entity.House;
import com.example.demo.service.ApartmentService;
import com.example.demo.service.HouseService;
import com.example.demo.entity.Apartment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(path = "api/v1/apartment")
public class ApartmentController {
    private final ApartmentService service;
    private final HouseService hservice;

    @Autowired
    public ApartmentController(ApartmentService service,HouseService hservice) {
        this.service = service;
        this.hservice = hservice;
    }
    @GetMapping(path = "/all")
    public List<Apartment> getApartment() {
        return service.getApartments();
    }

    @PostMapping("/add-apartment")
    public void registerApartment(@RequestBody Apartment apartment) {
        service.addNewApartment(apartment);
    }

//    @PostMapping("/add-houses")
//    public void registerHouse(@RequestBody List<HouseReqDto> houseReqDto) {
//        hservice.addNewHouse(houseReqDto);
//    }

    @PostMapping("/add-house")
    public void registerHouse(@RequestBody HouseReqDto houseReqDto) {
        log.info("Received request to add house:");
        log.info("Name: {}", houseReqDto.getName());
        log.info("Square Footage: {}", houseReqDto.getSqrt());
        log.info("Side Facing: {}", houseReqDto.getSidefacing());
        log.info("Price: {}", houseReqDto.getPrice());
        log.info("BHK: {}", houseReqDto.getBHK());

        hservice.addNewHouse(houseReqDto);
    }

    @DeleteMapping(path = "{ApartmentId}")
    public void deleteApartment(@PathVariable("ApartmentId") Long Id) {
        service.deleteApartment(Id);
    }
}
