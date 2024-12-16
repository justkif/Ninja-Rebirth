package dev.kyky.NR.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.kyky.NR.Exceptions.NinjaNotFoundException;
import dev.kyky.NR.Models.Ninja;
import dev.kyky.NR.Services.NinjaService;

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
    
}
