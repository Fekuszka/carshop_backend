package dev.daniel.carshop.dto;

import dev.daniel.carshop.model.Role;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class LoginResponseDto {
    private String token;

    public LoginResponseDto(String token){
        this.token = token;
    }
}
