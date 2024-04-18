package br.com.dio.picpayclone.infrastructure.web.mappers;

import br.com.dio.picpayclone.infrastructure.web.requests.LoginRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthenticationTokenMapper {

    public static UsernamePasswordAuthenticationToken toAuthenticationToken(LoginRequest loginRequest) {
        return new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
    }

}
