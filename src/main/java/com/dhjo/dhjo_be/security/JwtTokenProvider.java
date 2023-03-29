package com.dhjo.dhjo_be.security;

import com.dhjo.dhjo_be.constant.ErrorMessage;
import com.dhjo.dhjo_be.exception.CustomException;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {
    @Value("${app.jwt-secret}")
    private String jwtSecret;
    @Value("${app.jwt-expiration-milliseconds}")
    private int jwtExpiMs;
    // generate tokens
    public String generateToken(Authentication authentication){
        String username = authentication.getName();
        Date currDate = new Date();
        Date expiDate = new Date(currDate.getTime() + this.jwtExpiMs);
        return Jwts.builder().setSubject(username)
                .setIssuedAt(currDate)
                .setExpiration(expiDate)
                .signWith(SignatureAlgorithm.HS512, this.jwtSecret)
                .compact();
    }
    // get username from jwt token
    public String getUsernameByJwt(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(this.jwtSecret)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
    // validate jwt token
    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(this.jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            throw new CustomException(HttpStatus.BAD_REQUEST, ErrorMessage.INVALID_JWT_SIGNATURE);
        } catch (MalformedJwtException e) {
            throw new CustomException(HttpStatus.BAD_REQUEST, ErrorMessage.INVALID_JWT_TOKEN);
        } catch (ExpiredJwtException e) {
            throw new CustomException(HttpStatus.BAD_REQUEST, ErrorMessage.EXPIRED_JWT_TOKEN);
        } catch (UnsupportedJwtException e) {
            throw new CustomException(HttpStatus.BAD_REQUEST, ErrorMessage.UNSUPPORTED_JWT_TOKEN);
        } catch (IllegalArgumentException e) {
            throw new CustomException(HttpStatus.BAD_REQUEST, ErrorMessage.EMPTY_JWT_CLAIMS_STRING);
        }
    }
}
