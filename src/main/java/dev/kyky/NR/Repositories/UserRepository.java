package dev.kyky.NR.Repositories;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import dev.kyky.NR.Models.User;

public interface UserRepository extends ListCrudRepository<User, Integer> {

    @Query("SELECT * FROM \"user\" WHERE username = :username")
    Optional<User> findByExactName(String username);

}
