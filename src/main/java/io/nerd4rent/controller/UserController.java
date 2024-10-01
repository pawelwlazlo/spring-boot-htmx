package io.nerd4rent.controller;

import io.nerd4rent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String listUsers(Model model) {
        model.addAttribute("users", userRepository.findAllProjectedBy());
        return "index";
    }

    @GetMapping("/users")
    public String getUserList(Model model) {
        model.addAttribute("users", userRepository.findAllProjectedBy());
        return "fragments/user-list :: userList";
    }
}
