package dev.kyky.NR.Services;

import java.util.Base64;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {

    private final SecretKey key;
    private final String secret = "NzgzOTc2MzMxZTIwMjg0ZDgxM2JjYzA1NzY5OGExZDI2M2NiMjUyZTEzNzhhY2JlMjkw";

    public JWTService() {
        this.key = Keys.hmacShaKeyFor(Base64.getEncoder().encode(secret.getBytes()));
    }

    public String generateToken(String username) {
        Date now = new Date();
        return Jwts.builder()
            .subject(username)
            .issuedAt(now)
            .expiration(new Date(now.getTime() + 10800))
            .signWith(key)
            .compact();
    }

}
