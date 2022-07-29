package dev.daniel.carshop.controller;


import dev.daniel.carshop.dto.LoginDto;
import dev.daniel.carshop.dto.LoginResponseDto;
import dev.daniel.carshop.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RequestMapping
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> Login(@RequestBody LoginDto loginDto) throws Exception{
        System.out.println("logging post");
        String token = loginService.login(loginDto);
        String role = loginService.getRoleByEmail(loginDto.getEmail());
        return new ResponseEntity<>(new LoginResponseDto(token, role), HttpStatus.OK);
    }

}
