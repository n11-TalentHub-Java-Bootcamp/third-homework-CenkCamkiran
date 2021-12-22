package com.thirdhomework.cenkcamkiran.controllers;

import java.util.List;
import java.util.Locale.Category;

import com.thirdhomework.cenkcamkiran.entities.User;
import com.thirdhomework.cenkcamkiran.exception.UserException;
import com.thirdhomework.cenkcamkiran.services.UserEntityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserEntityService userEntityService;

    @GetMapping("")
    public List<User> findAll() {

        List<User> user = userEntityService.findAll();

        if (user == null || user.size() == 0) {
            throw new UserException("Kayıtlı herhangi bir kullanıcı yoktur.");
        }

        return userEntityService.findAll();
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody User user) {

        user = userEntityService.save(user);

        if (user == null) {
            throw new UserException("Kullanıcıyı kaydederken hata meydana geldi.");
        }

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable String id) {

        User user = userEntityService.findById(id);

        if (user == null) {
            throw new UserException(id + " ID li kullanıcı yoktur.");
        }

        return user;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        userEntityService.deleteById(id);
    }

}
