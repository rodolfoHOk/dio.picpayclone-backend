package br.com.dio.picpayclone.infrastructure.web.security.services.impl;

import br.com.dio.picpayclone.domain.models.User;
import br.com.dio.picpayclone.infrastructure.web.security.services.ITokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.UUID;

public class JJWTTokenService implements ITokenService {

    @Value("${picpayclone.jwt.expiration}")
    private String expiration;

    @Value("${picpayclone.jwt.secret}")
    private String secret;

    @Override
    public String generateToken(Authentication authentication) {
        var loggedUser = (User) authentication.getPrincipal();
        var now = new Date();
        var expirationDate = new Date(now.getTime() + Long.parseLong(expiration));
        var secretKey = getSecretKey();
        return Jwts.builder()
                .issuer("Api PicPay Clone")
                .subject(loggedUser.getId().toString())
                .issuedAt(now)
                .expiration(expirationDate)
                .signWith(secretKey, Jwts.SIG.HS256)
                .compact();
    }

    @Override
    public Boolean isTokenValid(String token) {
        return getJwtParser().isSigned(token);
    }

    @Override
    public UUID getUserId(String token) {
        Claims claims = getJwtParser().parseSignedClaims(token).getPayload();
        return UUID.fromString(claims.getSubject());
    }

    private JwtParser getJwtParser() {
        var secretKey = getSecretKey();
        return Jwts.parser().verifyWith(secretKey).build();
    }

    private SecretKeySpec getSecretKey() {
        return new SecretKeySpec(secret.getBytes(), Jwts.SIG.HS256.toString());
    }

}
