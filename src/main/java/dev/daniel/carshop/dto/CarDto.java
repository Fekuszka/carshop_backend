package dev.daniel.carshop.dto;

import dev.daniel.carshop.model.Car;
import lombok.Data;

@Data
public class CarDto {
    private Long id;
    private String manufacturer;
    private String country;
    private String model;

    public CarDto(Car car){
        this.id = car.getId();
        this.manufacturer = car.getManufacturer();
        this.country = car.getCountry();
        this.model = car.getModel();
    }

    public CarDto(){}
}
