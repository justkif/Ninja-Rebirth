package dev.kyky.NR.Services;

import java.util.Base64;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {

    private final SecretKey key;
    private String secret = "NzgzOTc2MzMxZTIwMjg0ZDgxM2JjYzA1NzY5OGExZDI2M2NiMjUyZTEzNzhhY2JlMjkw";
    private long expirationTime = 10800;

    public JWTService() {
        this.key = Keys.hmacShaKeyFor(Base64.getEncoder().encode(secret.getBytes()));
    }

    public String generateToken(String username) {
        Date now = new Date();
        return Jwts.builder()
            .subject(username)
            .issuedAt(now)
            .expiration(new Date(now.getTime() + expirationTime))
            .signWith(key)
            .compact();
    }

}
