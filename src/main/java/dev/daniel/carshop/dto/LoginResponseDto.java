package dev.daniel.carshop.dto;

import dev.daniel.carshop.model.Role;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class LoginResponseDto {
    private String token;
    private String role;

    public LoginResponseDto(String token,  String role){
        this.token = token;
        this.role = role;
    }
}
