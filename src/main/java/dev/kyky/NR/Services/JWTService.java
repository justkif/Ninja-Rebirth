package dev.kyky.NR.Services;

import java.security.MessageDigest;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;

@Service
public class JWTService {

    @Value("${jwt.secret}")
    private String secret; 

    public SecretKeySpec createKey(String secret) {
        try {
            return new SecretKeySpec(MessageDigest.getInstance("SHA-256").digest(secret.getBytes()),"AES");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String generateToken(String username) {
        Date now = new Date();
        return Jwts.builder()
            .subject(username)
            .issuedAt(now)
            .expiration(new Date(now.getTime() + 10800))
            .encryptWith(createKey(secret), Jwts.ENC.A256GCM)
            .compact();
    }

}
