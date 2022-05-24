package ru.avolsky.kata.crud.dao;


import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import ru.avolsky.kata.crud.model.User;

import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUser() {
        return entityManager.createQuery("select u from User u", User.class)
                .getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(int id) {
        return entityManager.getReference(User.class, id);
    }

    public void deleteUser(int id) {
        entityManager.remove(getUser(id));
    }

    @Override
    public User findById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

}
