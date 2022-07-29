package dev.daniel.carshop.service;

import dev.daniel.carshop.model.Car;
import dev.daniel.carshop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCars(){
        return carRepository.findAll();
    }

    public void addNewCar(Car car) {
        carRepository.save(car);
        System.out.println(car);
    }

    public void deleteCar(Long id) {
        boolean exists = carRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("car with id: "  + id + " doesn't exists");
        }
        carRepository.deleteById(id);
    }

    public void updateCar(Car car) {
        //Car c = carRepository.getReferenceById(car.getId());
        carRepository.save(car);
    }
}
