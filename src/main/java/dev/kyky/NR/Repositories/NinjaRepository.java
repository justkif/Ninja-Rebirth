package dev.kyky.NR.Repositories;

import org.springframework.data.repository.ListCrudRepository;

import dev.kyky.NR.Models.Ninja;

public interface NinjaRepository extends ListCrudRepository<Ninja, Integer> {

}
