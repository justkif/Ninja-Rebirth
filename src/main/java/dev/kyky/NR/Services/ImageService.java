package dev.kyky.NR.Services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.kyky.NR.Models.Image;
import dev.kyky.NR.Repositories.ImageRepository;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public void createOne(String imagePath) throws IOException {
        Path path = Paths.get(imagePath);
        byte[] data = Files.readAllBytes(path);
        imageRepository.save(new Image(null, data));
    }

    public Optional<Image> getOne(Integer id) {
        return imageRepository.findById(id);
    }
}
