package dev.kyky.NR.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.kyky.NR.Exceptions.UserConflictException;
import dev.kyky.NR.Models.User;
import dev.kyky.NR.Services.UserService;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    List<User> getAll() {
        return userService.getAll();
    }    

    @PostMapping("/register")
    void registerUser(@Valid @RequestBody User user) {
        if (!userService.registerUser(user)) {
            throw new UserConflictException();
        }
    }

}
