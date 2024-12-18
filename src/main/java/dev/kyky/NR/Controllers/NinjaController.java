package dev.kyky.NR.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.kyky.NR.Exceptions.NinjaConflictException;
import dev.kyky.NR.Exceptions.NinjaNotFoundException;
import dev.kyky.NR.Models.Ninja;
import dev.kyky.NR.Services.NinjaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("")
    List<Ninja> getAll() {
        List<Ninja> ninjaGetAll = ninjaService.getAll();
        if (ninjaGetAll.isEmpty()) {
            throw new NinjaNotFoundException();
        }
        return ninjaGetAll;
    }

    @GetMapping("/{id}")
    Optional<Ninja> getOne(@PathVariable Integer id) {
        Optional<Ninja> ninjaGetOne = ninjaService.getOne(id);
        if (ninjaGetOne.isEmpty()) {
            throw new NinjaNotFoundException();
        }
        return ninjaGetOne;
    }

    @GetMapping("/search")
    List<Ninja> getMany(@RequestParam String name) {
        List<Ninja> ninjaGetMany = ninjaService.getMany(name);
        if (ninjaGetMany.isEmpty()) {
            throw new NinjaNotFoundException();
        }
        return ninjaGetMany;
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void createOne(@Valid @RequestBody Ninja ninja) {
        if (!ninjaService.createOne(ninja)) {
            throw new NinjaConflictException();
        }
    }

    @PutMapping("/{id}")
    void updateOne(@Valid @RequestBody Ninja ninja, @PathVariable Integer id) {
        Optional<Ninja> ninjaGetOne = ninjaService.getOne(id);
        if (ninjaGetOne.isEmpty()) {
            throw new NinjaNotFoundException();
        }
        ninjaService.updateOne(ninja, id);
    }

    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable Integer id) {
        Optional<Ninja> ninjaGetOne = ninjaService.getOne(id);
        if (ninjaGetOne.isEmpty()) {
            throw new NinjaNotFoundException();
        }
        ninjaService.deleteOne(id);
    }

}
