package com.comarch.szkolenia.hibernate.controllers;

import com.comarch.szkolenia.hibernate.model.User;
import com.comarch.szkolenia.hibernate.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class SimpleController {

    private final IUserService userService;

    @GetMapping("/test1")
    public void persist() {
        User user1 = new User(0, "Janusz", "Kowalski", 30);
        User user2 = new User(0, "Zbyszek", "Malinowski", 50);
        User user3 = new User(0, "Wiesiek", "Jakis", 10);
        this.userService.persistUser(user1);
        this.userService.persistUser(user2);
        this.userService.persistUser(user3);
    }

    @GetMapping("/test2")
    public List<User> getAll() {
        return this.userService.getAll();
    }

    @GetMapping("/test3/{id}")
    public User getById(@PathVariable("id") int id) {
        Optional<User> userBox = this.userService.getById(id);
        return userBox.orElseGet(() -> new User(0, "default", "default", 0));
    }
}
