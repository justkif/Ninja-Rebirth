package dev.kyky.NR.Services;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import dev.kyky.NR.Models.JWT;
import dev.kyky.NR.Models.User;
import dev.kyky.NR.Repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final JWTService jwtService;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, JWTService jwtService, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean registerUser(User user) {
        if (!userRepository.findByExactName(user.username()).isEmpty()) {
            return false;
        }
        userRepository.save(user.setHashedPassword(passwordEncoder.encode(user.password())));
        return true;
    }

    public JWT loginUser(User user) {
        Optional<User> userGetOne = userRepository.findByExactName(user.username());
        if (userGetOne.isEmpty() || !passwordEncoder.matches(user.password(), userGetOne.get().password())) {
            return null;
        }
        return new JWT(user.username(), jwtService.generateToken(user.username()));
    }

}
