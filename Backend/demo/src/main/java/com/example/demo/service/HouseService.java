package com.example.demo.service;

import com.example.demo.dto.HouseReqDto;
import com.example.demo.entity.Apartment;
import com.example.demo.entity.House;
import com.example.demo.repository.ApartmentRepository;
import com.example.demo.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HouseService {

    private final HouseRepository houseRepository;
    private final ApartmentRepository apartmentRepository;

    @Autowired
    public HouseService(HouseRepository houseRepository, ApartmentRepository apartmentRepository) {
        this.houseRepository = houseRepository;
        this.apartmentRepository = apartmentRepository;
    }

    public void addNewHouse(HouseReqDto houseReqDto) {
        try {
            House house = new House();
            house.setName(houseReqDto.getName());
            house.setSqrt(Long.parseLong(houseReqDto.getSqrt()));
            house.setBHK(houseReqDto.getBHK());
            house.setSideFacing(houseReqDto.getSidefacing());
            house.setPrice(houseReqDto.getPrice());
            Apartment apartment = new Apartment();
            apartment.setId(houseReqDto.getAppartmentId());

            house.setApartment(apartment);

            houseRepository.save(house);
        } catch (NumberFormatException e) {
            // Handle number format exception
            System.err.println("Error parsing long value: " + e.getMessage());
        }
        //houseRepository.save(houseReqDto);
    }

//    public void addNewHouses(List<HouseReqDto> houseReqDtoList) {
//        for (HouseReqDto houseReqDto : houseReqDtoList) {
//            addNewHouse(houseReqDto);
//        }
//    }
}
