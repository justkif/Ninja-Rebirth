package dev.kyky.NR.Services;

import java.util.List;
import java.util.Optional;

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

    public Optional<Ninja> getOne(Integer id) {
        return ninjaRepository.findById(id);
    }

    public List<Ninja> getMany(String name) {
        return ninjaRepository.findByName(name);
    }

    public void createOne(Ninja ninja) {
        ninjaRepository.save(ninja);
    }

    public void updateOne(Ninja ninja, Integer id) {
        Ninja ninjaGetOne = ninjaRepository.findById(id).get();
        Ninja updatedNinja = new Ninja(
            ninjaGetOne.id(),
            ninja.name(),
            ninja.skill1(),
            ninja.skill2(),
            ninja.skill3(),
            ninja.skill4()
        );
        ninjaRepository.save(updatedNinja);
    }

    public void deleteOne(Integer id) {
        ninjaRepository.deleteById(id);
    }

}
