package com.comarch.szkolenia.hibernate.services;

import com.comarch.szkolenia.hibernate.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAll();
    Optional<User> getById(int id);
    void persistUser(User user);
}
