package dev.kyky.NR.Services;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.kyky.NR.Models.Ninja;

@Service
public class ImageService {

    private final Cloudinary cloudinary;

    public ImageService(@Value("${cloudinary.cloudName}") String cloudName,
            @Value("${cloudinary.apiKey}") String apiKey,
            @Value("${cloudinary.apiSecret}") String apiSecret) {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret));
    }

    public Ninja createOne(String ninjaJson, MultipartFile picture) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Ninja ninja = objectMapper.readValue(ninjaJson, Ninja.class);
        String imageUrl = (String) cloudinary.uploader().upload(picture.getBytes(), ObjectUtils.emptyMap()).get("url");  
        return ninja.createOne(imageUrl);
    }

    public void deleteOne(String imageUrl) throws IOException {
        Pattern pattern = Pattern.compile("/upload/v\\d+/(.*?)(?=\\.)");
        Matcher matcher = pattern.matcher(imageUrl);
        if (matcher.find()) {
            cloudinary.uploader().destroy(matcher.group(1), ObjectUtils.emptyMap());
        }
    }

}
