package dev.kyky.NR.Repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import dev.kyky.NR.Models.Ninja;
import java.util.List;

public interface NinjaRepository extends ListCrudRepository<Ninja, Integer> {

    @Query("SELECT * FROM Ninja WHERE name ILIKE CONCAT('%', :name, '%')")
    List<Ninja> findByName(String name);

}