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
    public String dashboard(Model model) {
        model.addAttribute("users", userRepository.findAllProjectedBy());
        model.addAttribute("newUser", new UserDto());
        return "index";
    }

    @PostMapping("/users")
    public String addUser(@Valid @ModelAttribute("newUser") UserDto newUser, 
                          BindingResult result, Model model) {
        if (!newUser.getPassword().equals(newUser.getConfirmPassword())) {
            result.rejectValue("confirmPassword", "error.newUser", "Passwords do not match");
        }
        if (result.hasErrors()) {
            model.addAttribute("users", userRepository.findAllProjectedBy());
            return "index";
        }
        userService.createUser(newUser);
        return "redirect:/";
    }
}
