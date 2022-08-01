package dev.daniel.carshop.repository;

import dev.daniel.carshop.model.Role;
import dev.daniel.carshop.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);

    void addRoleToUser(String email, String roleName);

    User getUser(String email);
     List<User> getUsers();
}
