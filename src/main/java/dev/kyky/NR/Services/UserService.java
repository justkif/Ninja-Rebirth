package dev.kyky.NR.Services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import dev.kyky.NR.Models.User;
import dev.kyky.NR.Repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public boolean registerUser(User user) {
        if (!userRepository.findByExactName(user.username()).isEmpty()) {
            return false;
        }
        userRepository.save(user.setHashedPassword(passwordEncoder.encode(user.password())));
        return true;
    }

}
