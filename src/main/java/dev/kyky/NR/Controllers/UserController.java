package dev.kyky.NR.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.kyky.NR.Services.UserService;

@RestController
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

}
