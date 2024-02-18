package com.example.demo.Apartments;

import com.example.demo.entity.Apartment;
import com.example.demo.repository.ApartmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Component
public class ApartmentConfig {
    private ApartmentRepository apartmentRepository;
    public ApartmentConfig(){
        this.apartmentRepository = apartmentRepository;
    }
 @Bean
    CommandLineRunner commandLineRunner(
            ApartmentRepository repository){
return args -> {
Apartment deepak = new Apartment("Deepak","Saravanampatti",20,15,5, LocalDate.of(2000, Month.JANUARY,2));
Apartment kavi  = new Apartment("kavi","Peelamedu",30,27,3,LocalDate.of(2010,Month.APRIL,20));
repository.saveAll(List.of(deepak,kavi));
};
 }
}
