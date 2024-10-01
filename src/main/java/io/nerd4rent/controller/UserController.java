package io.nerd4rent.controller;

import io.nerd4rent.dto.UserDto;
import io.nerd4rent.repository.UserRepository;
import io.nerd4rent.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String listUsers(Model model) {
        model.addAttribute("users", userRepository.findAllProjectedBy());
        model.addAttribute("newUser", new UserDto());
        return "index";
    }

    @GetMapping("/users")
    public String getUserList(Model model) {
        model.addAttribute("users", userRepository.findAllProjectedBy());
        return "fragments/user-list :: userList";
    }

    @PostMapping("/users")
    public String addUser(@Valid @ModelAttribute("newUser") UserDto newUser, 
                          BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("users", userRepository.findAllProjectedBy());
            return "fragments/user-form :: userForm";
        }
        userService.createUser(newUser);
        return getUserList(model);
    }
}
