package dev.kyky.NR.Models;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotEmpty;

public record User(

    @Id
    Integer id,

    @NotEmpty
    String username,

    @NotEmpty
    String password
    
) {

    public User setHashedPassword(String password) {
        return new User(
            this.id,
            this.username,
            password
        );
    }

}
