package com.thirdhomework.cenkcamkiran.services;

import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;

import com.thirdhomework.cenkcamkiran.entities.User;
import com.thirdhomework.cenkcamkiran.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User category) {
        return userRepository.save(category);
    }

    public User findById(String id) {

        Optional<User> optional = userRepository.findById(id);

        User user = null;
        if (optional.isPresent()) {
            user = optional.get();
        }

        return user;
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

}
