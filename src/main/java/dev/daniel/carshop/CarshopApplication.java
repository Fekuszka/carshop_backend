package dev.daniel.carshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class CarshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarshopApplication.class, args);
	}

	/*@Bean
	InitializingBean sendDatabase() {
		return () -> {

			//userService.registerInitial(new User("petike@gmail.com", "admin",Role.GERMANY));
			//userService.registerInitial(new User("szala@gmail.com", "admin",Role.JAPAN));
		};
	}*/
}
