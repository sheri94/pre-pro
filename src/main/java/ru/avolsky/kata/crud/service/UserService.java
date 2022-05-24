package ru.avolsky.kata.crud.service;

import ru.avolsky.kata.crud.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUser();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);

    public User findById(int id);

    public void updateUser(User user);
}
