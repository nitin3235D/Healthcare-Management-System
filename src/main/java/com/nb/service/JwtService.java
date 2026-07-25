package com.nb.service;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	
    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long jwtExpiration;
	
    
    private Key getSignkey() {
    	
    	return Keys.hmacShaKeyFor(secretKey.getBytes());
    }
    
    
    public String generateToken(String email) {
    	return Jwts.builder()
    			.subject(email)
    			.issuedAt(new Date())
    			.expiration(new Date(System.currentTimeMillis()+ jwtExpiration))
    			.signWith((SecretKey) getSignkey())
    			.compact();
    }
    
    
    public Claims extractAllClaims(String token) {
    	
    	return Jwts.parser()
    			.verifyWith((SecretKey) getSignkey())
    			.build()
    			.parseSignedClaims(token)
    			.getPayload();
    }
    
    
    
    public String extractUsername(String token) {
    	
    	Claims claims = extractAllClaims(token);
    	return claims.getSubject();
    
    }
    
    
    public Date extractExpiration(String token) {
    	
    	Claims claims = extractAllClaims(token);
    	
    	return claims.getExpiration();
    
    }
    
    
    //check token expiry
    
    public boolean isTokenExpired(String token) {
    	
    	Date expirationDate = extractExpiration(token);
    	
    	return expirationDate.before(new Date());
    }
    
    //validation token 
    
    public boolean isTokenValid(String token, UserDetails userDetails) {
    	
    	String email = extractUsername(token);
    	
    	
    	return email.equals(userDetails.getUsername()) && !isTokenExpired(token);
    	
    	
    }
    
}