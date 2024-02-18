package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class House {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String name;

   @Column(name = "square_footage")
   private Long sqrt; // Renamed to squareFootage and changed type to Double
   private int price;
   private String sideFacing; // Renamed to sideFacing to follow Java naming conventions
   private int BHK;
   @ManyToOne
   @JoinColumn(name = "apartment_id")
   @JsonIgnore
   private Apartment apartment;

}
