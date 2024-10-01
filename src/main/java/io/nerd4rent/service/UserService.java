package io.nerd4rent.service;

import io.nerd4rent.dto.UserDto;
import io.nerd4rent.model.AppUser;
import io.nerd4rent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(UserDto userDto) {
        AppUser user = new AppUser();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        // W rzeczywistej aplikacji należałoby zahashować hasło przed zapisaniem
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
    }
}