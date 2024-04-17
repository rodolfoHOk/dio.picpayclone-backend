package br.com.dio.picpayclone.application.services;

import br.com.dio.picpayclone.application.ports.inbound.ITokenService;
import br.com.dio.picpayclone.domain.models.User;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

public class TokenService implements ITokenService {

    @Value("${picpayclone.jwt.expiration}")
    private String expiration;

    @Value("${picpayclone.jwt.secret}")
    private String secret;

    @Override
    public String generateToken(Authentication authentication) {
        var loggedUser = (User) authentication.getPrincipal();
        var now = new Date();
        var expirationDate = new Date(now.getTime() + Long.parseLong(expiration));
        var key = new SecretKeySpec(secret.getBytes(), Jwts.SIG.HS256.toString());
        return Jwts.builder()
                .issuer("Api PicPay Clone")
                .subject(loggedUser.getId().toString())
                .issuedAt(now)
                .expiration(expirationDate)
                .signWith(key, Jwts.SIG.HS256)
                .compact();
    }

}
