package com.example.rentcar.car.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Car {

    private UUID id;
    private Model model;
    private Integer price;
    private String engine;
    private String transmission;
    private String weight;
    private String dynamicIndicators;
    private String FuelConsumption;
    private boolean available;
    private String pathImg;
    private LocalDate pickupDate;
    private LocalDate returnDate;


}
