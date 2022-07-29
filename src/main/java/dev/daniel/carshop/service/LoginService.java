package dev.daniel.carshop.service;

import dev.daniel.carshop.dto.LoginDto;
import dev.daniel.carshop.model.User;
import dev.daniel.carshop.repository.UserRepository;

public class LoginService {

    private UserRepository userRepository;

    public String login(LoginDto loginDto) throws Exception{
        if(userRepository.findByEmail(loginDto.getEmail()) == null)
            throw new Exception("User does not exist");
        if(!loginDto.getPassword().equals(userRepository.findByEmail(loginDto.getEmail()).getPassword()))
            throw new Exception("Incorrect password");
        User user = userRepository.findByEmail(loginDto.getEmail());
        return user.getEmail();
    }

    public String getRoleByEmail(String email) {
        return userRepository.findByEmail(email).getRole();
    }
}
