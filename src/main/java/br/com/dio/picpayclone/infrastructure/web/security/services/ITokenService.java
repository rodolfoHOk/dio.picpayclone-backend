package br.com.dio.picpayclone.infrastructure.web.security.services;

import org.springframework.security.core.Authentication;

import java.util.UUID;

public interface ITokenService {

    String generateToken(Authentication authentication);

    Boolean isTokenValid(String token);

    UUID getUserId(String token);

}
