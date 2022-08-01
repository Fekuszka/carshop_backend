package dev.daniel.carshop;

import dev.daniel.carshop.model.Role;
import dev.daniel.carshop.model.User;
import dev.daniel.carshop.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

	@Autowired
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "SUPERUSER"));
			userService.saveRole(new Role(null, "AMERICA"));
			userService.saveRole(new Role(null, "GERMANY"));
			userService.saveRole(new Role(null, "JAPAN"));

			userService.saveUser(new User(null, "Pepe", "funkyteam", null));
			userService.saveUser(new User(null, "Szala", "hobbit", null));
			userService.saveUser(new User(null, "Petike","magas", null));

			userService.addRoleToUser("Pepe", "JAPAN");
			userService.addRoleToUser("Szala", "SUPERUSER");
		};
	}
}
