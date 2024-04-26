package com.example.felipe.sec.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    public String generateToken(String username){
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + expiration))
            .signWith(SignatureAlgorithm.HS512, secret)
            .compact();
    }     
    
    public String extractUserName(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token, String username){
        final String extractedUsername = extractUserName(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    public boolean isTokenExpired(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getExpiration().before(new Date());
    }


}
