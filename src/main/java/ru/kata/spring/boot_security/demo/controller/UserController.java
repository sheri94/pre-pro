package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import java.util.List;


@Controller
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserController(UserServiceImpl userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/user/my")
    public String getUser(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("users", user);
        return "user-list";
    }

    @GetMapping("/user/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/login";
    }


    @GetMapping("/user/my-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
       // List<Role> listRoles = roleService.findAll();
        model.addAttribute("user", user);
       // model.addAttribute("listRoles", listRoles);
        return "user-update";
    }

    @PostMapping("/user/my-update")
    public String updateUser(User user,
                             @RequestParam(value = "rolesId") String[] roles) {
     //   user.setRoles(roleService.getSetRoles(roles));
        userService.saveUser(user);
        return "redirect:/user/my";
    }

}
