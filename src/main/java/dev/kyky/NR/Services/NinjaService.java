package dev.kyky.NR.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.kyky.NR.Models.Ninja;
import dev.kyky.NR.Repositories.NinjaRepository;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<Ninja> getAll() {
        return ninjaRepository.findAll();
    }
    
}
