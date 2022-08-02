package dev.daniel.carshop.controller;

import dev.daniel.carshop.model.Car;
import dev.daniel.carshop.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/car")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class CarController {

    @Autowired
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getCars(){
        return carService.getCars();
    }

    @PostMapping
    public void registerNewCar(@RequestBody Car car){
        carService.addNewCar(car);
    }

    @DeleteMapping("/delete/{carId}")
    public void deleteCar(@PathVariable("carId") Long id){
        carService.deleteCar(id);
    }

    @PutMapping("/put/")
    public void updateCar(@RequestBody Car car){
        carService.updateCar(car);
    }
}
