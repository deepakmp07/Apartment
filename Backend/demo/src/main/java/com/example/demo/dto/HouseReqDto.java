package com.example.demo.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class HouseReqDto {
    private long appartmentId;
    private String name;
    private String sqrt;
    private String sidefacing;
    private int BHK;
    private int price;
}
