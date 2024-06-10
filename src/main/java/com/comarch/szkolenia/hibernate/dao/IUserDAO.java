package com.comarch.szkolenia.hibernate.dao;

import com.comarch.szkolenia.hibernate.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserDAO {
    List<User> getAll();
    Optional<User> getById(int id);
    void persist(User user);
}
