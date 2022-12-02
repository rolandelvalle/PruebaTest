package com.sp2.apirestmongo.security.jwt;

import com.sp2.apirestmongo.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;


public class OperationJwtImpl implements OperationJwt{
    @Override
    public String generateJwt(User user, Calendar expirationData) {
        final String keySecret = "Ada123";
        return Jwts.builder()
                .setSubject(user.getId())
                .claim("name", user.getFullName())
                .setIssuedAt(new Date())
                .setExpiration(expirationData.getTime())
                .signWith(SignatureAlgorithm.HS256, keySecret)
                .compact();
    }
}
