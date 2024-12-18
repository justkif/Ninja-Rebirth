package dev.kyky.NR.Repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import dev.kyky.NR.Models.Ninja;
import java.util.List;
import java.util.Optional;

public interface NinjaRepository extends ListCrudRepository<Ninja, Integer> {

    @Query("SELECT * FROM Ninja WHERE name ILIKE CONCAT('%', :name, '%')")
    List<Ninja> findBySimilarName(String name);

    @Query("SELECT * FROM Ninja WHERE name = :name")
    Optional<Ninja> findByExactName(String name);

}
