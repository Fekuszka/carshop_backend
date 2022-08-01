package dev.daniel.carshop.service;

import dev.daniel.carshop.dto.LoginDto;
import dev.daniel.carshop.model.Role;
import dev.daniel.carshop.model.User;
import dev.daniel.carshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {



    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public String login(LoginDto loginDto) throws Exception{
        if(userRepository.findByEmail(loginDto.getEmail()) == null)
            throw new Exception("User does not exist");
        if(!passwordEncoder.matches(loginDto.getPassword(), userRepository.findByEmail(loginDto.getEmail()).getPassword()))
            throw new Exception("Incorrect password");
        User user = userRepository.findByEmail(loginDto.getEmail());
        return user.getEmail();
    }

    public Role getRoleByEmail(String email) {
        return userRepository.findByEmail(email).getRole();
    }
}
