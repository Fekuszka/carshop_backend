package dev.daniel.carshop.controller;


import dev.daniel.carshop.dto.LoginDto;
import dev.daniel.carshop.dto.LoginResponseDto;

import dev.daniel.carshop.model.MyUserDetails;
import dev.daniel.carshop.service.JwtUtil;
import dev.daniel.carshop.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private JwtUtil jwtTokenUtil;

    @GetMapping("/home")
    public String hello(){
        return "Home";
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> createAuthenticationToken(@RequestBody LoginDto loginDto) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
            );
        } catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }

        final MyUserDetails userDetails = userDetailsService.loadUserByUsername(loginDto.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return new ResponseEntity<>(new LoginResponseDto(token), HttpStatus.OK);
    }

}
