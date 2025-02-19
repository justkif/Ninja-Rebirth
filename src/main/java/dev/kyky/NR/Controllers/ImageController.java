package dev.kyky.NR.Controllers;

import java.io.IOException;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.kyky.NR.Models.Image;
import dev.kyky.NR.Services.ImageService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/images")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/{id}")
    Optional<Image> getOne(@PathVariable Integer id) throws Exception {
        Optional<Image> imageGetOne = imageService.getOne(id);
        if (imageGetOne.isEmpty()) {
            throw new Exception();
        }
        return imageGetOne;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/upload")
    void createOne(@Valid @RequestParam String imagePath) throws IOException {
        imageService.createOne(imagePath);
    }

}
