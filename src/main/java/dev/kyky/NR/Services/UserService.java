package dev.kyky.NR.Services;

import org.springframework.stereotype.Service;

import dev.kyky.NR.Repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
