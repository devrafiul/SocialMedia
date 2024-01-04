package com.zosh.config;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtProvider {
	
	private static SecretKey key=Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());

	
	public static String generateToken(Authentication auth) {
		
		String jwt=Jwts.builder()
				.setIssuer("CodeWithZosh")
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime()+86400000))
				.claim("email", auth.getName())
				.signWith(key)
				.compact();
		
		return jwt;
	}
	
	public static String getEmailFromJwtToken(String jwt) {
		//Bearer token into postman
		
		jwt=jwt.substring(7);//seven letter skip(Bearer=6+1(space))
		
		Claims claims=Jwts.parser()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(jwt)
				.getBody();
		
		String email=String.valueOf(claims.get("email"));
		
		return email;
	}
	
}
