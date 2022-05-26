package ru.avolsky.kata.crud_springboot.pp_3_1_1_cred_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.avolsky.kata.crud_springboot.pp_3_1_1_cred_springboot.model.User;
import ru.avolsky.kata.crud_springboot.pp_3_1_1_cred_springboot.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(int id) {
        User user = null;
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            user = optional.get();
        }
        return user;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}