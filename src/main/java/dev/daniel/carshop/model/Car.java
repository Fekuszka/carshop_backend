package dev.daniel.carshop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;

    private String country;
    private String manufacturer;

    public Car(){}

    public Car(String country, String manufacturer, String model){
        this.model = model;
        this.country = country;
        this.manufacturer = manufacturer;
    }

}
