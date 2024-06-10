package com.comarch.szkolenia.hibernate.services;

import com.comarch.szkolenia.hibernate.dao.IUserDAO;
import com.comarch.szkolenia.hibernate.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserDAO userDAO;

    @Override
    public List<User> getAll() {
        return this.userDAO.getAll();
    }

    @Override
    public Optional<User> getById(int id) {
        return this.userDAO.getById(id);
    }

    @Override
    public void persistUser(User user) {
        this.userDAO.persist(user);
    }
}
