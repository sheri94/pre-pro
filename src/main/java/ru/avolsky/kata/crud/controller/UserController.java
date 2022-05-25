package ru.avolsky.kata.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.avolsky.kata.crud.model.User;
import ru.avolsky.kata.crud.service.UserService;


@Controller
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;

    }

    @GetMapping("/")
    public String showAllUser(Model model) {
        model.addAttribute("allUser", service.getAllUser());
        return "all-user";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "add-user";
    }

    @PostMapping
    public String saveUser(@ModelAttribute("user") User user) {
        service.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        service.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/edit-user/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model) {
        User user = service.findById(id);
        model.addAttribute("user", user);
        return "edit-user";
    }

    @PatchMapping("/edit-user")
    public String updateUser(@ModelAttribute() User user) {
        service.updateUser(user);
        return "redirect:/";
    }
}