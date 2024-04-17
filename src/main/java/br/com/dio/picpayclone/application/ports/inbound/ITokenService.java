package br.com.dio.picpayclone.application.ports.inbound;

import org.springframework.security.core.Authentication;

public interface ITokenService {

    String generateToken(Authentication authentication);

}
