package dev.daniel.carshop.config;

import dev.daniel.carshop.model.Car;
import dev.daniel.carshop.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CarConfig {

    @Bean
    CommandLineRunner commandLineRunner(CarRepository repository){
        return args -> {
            Car x5 = new Car(
                    "GER",
                    "BMW",
                    "X5"

            );

            Car yaris = new Car(
                    "JAP",
                    "Toyota",
                    "Yaris"

            );

            repository.saveAll(
                    List.of(x5,yaris)
            );
        };
    }
}
