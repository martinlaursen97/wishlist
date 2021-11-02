package com.wishlist.project.domain.services;

import com.wishlist.project.domain.models.User;
import com.wishlist.project.repositories.UserRepository;
import com.wishlist.project.repositories.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(String username, String password, String email, String phone, String street, String city, String zip) {
        User user = new User(username, password, email, phone, street, city, zip);
        userRepository.createUser(user);
    }

    public boolean usernameTaken(String username) {
        return userRepository.usernameTaken(username);
    }

    public boolean loginValid(String username, String password) {
        return userRepository.loginValid(username, password);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findIdByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
