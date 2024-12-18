package dev.kyky.NR.Repositories;

import org.springframework.data.repository.ListCrudRepository;

import dev.kyky.NR.Models.User;

public interface UserRepository extends ListCrudRepository<User, Integer> {

}
