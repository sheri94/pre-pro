package ru.avolsky.kata.crud_springboot.pp_3_1_1_cred_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.avolsky.kata.crud_springboot.pp_3_1_1_cred_springboot.model.User;
import ru.avolsky.kata.crud_springboot.pp_3_1_1_cred_springboot.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("users", userList);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
}