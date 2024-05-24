package com.medisite.medicos.service;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {
    @Value("${security.jwt.secret-key}")
    private String secretKey;

    @Value("${security.jwt.expiration-time}")
    private long jwtExpiration;


    public String extractUsername(String token){
        return extractClaims(token, Claims::getSubject);
    }

    public Date extractExpirationDate(String token){
        return extractClaims(token, Claims::getExpiration);
    }

    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
    }

    public boolean isTokenExpired(String token){
        return extractExpirationDate(token).before(new Date());
    }

    public String generateToken(String username, String role, long id){
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        claims.put("id", id);
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String subject){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public boolean validateToken(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    public boolean validateIdInToken(String token, long id){
        Claims claims = extractAllClaims(token);
        return (((Number) claims.get("id")).longValue() == (id) && !isTokenExpired(token));
    }

    public boolean isPaciente(String token){
        Claims claims = extractAllClaims(token);
        return (((String) claims.get("role")).equals("paciente"));
    }

    public boolean isAdmin(String token){
        Claims claims = extractAllClaims(token);
        return (((String) claims.get("role")).equals("admin"));
    }

    public boolean isMedico(String token) {
        Claims claims = extractAllClaims(token);
        return (((String) claims.get("role")).equals("medico"));
    }

    public String getBearerToken(HttpServletRequest request){
        try {
            return request.getHeader("Authorization").substring(7);
        } catch (Exception e) {
            throw e;
        }
    }

    public long getJwtExpiration(){
        return jwtExpiration;
    }
}