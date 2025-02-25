package dev.kyky.NR.Services;

import java.util.Base64;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Service
public class JWTService {

    @Value("${jwt.secret}")
    private String secret; 
    private SecretKey key;
    
    @PostConstruct
    public void init() {
        key = Keys.hmacShaKeyFor(Base64.getEncoder().encode(secret.getBytes()));
    }

    public String generateToken(String username) {
        Date now = new Date();
        return Jwts.builder()
            .subject(username)
            .issuedAt(now)
            .expiration(new Date(now.getTime() + 10800 * 1000))
            .signWith(key, Jwts.SIG.HS256)
            .compact();
    }   

    public Claims decode(String token) {
        return Jwts.parser()
            .verifyWith(key)
            .build()
            .parseSignedClaims(token)
            .getPayload();
    }
}
