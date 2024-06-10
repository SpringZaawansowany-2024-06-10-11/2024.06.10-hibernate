package com.comarch.szkolenia.hibernate.dao;

import com.comarch.szkolenia.hibernate.model.User;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDAO implements IUserDAO {

    private final SessionFactory sessionFactory;

    @Override
    public List<User> getAll() {
        Session session = this.sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM com.comarch.szkolenia.hibernate.model.User", User.class);
        List<User> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public Optional<User> getById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM com.comarch.szkolenia.hibernate.model.User WHERE id = :id", User.class);
        query.setParameter("id", id);
        try {
            User result = query.getSingleResult();
            return Optional.of(result);
        } catch (NoResultException e) {
            return Optional.empty();
        } finally {
            session.close();
        }
    }

    @Override
    public void persist(User user) {
        Session session = this.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}
