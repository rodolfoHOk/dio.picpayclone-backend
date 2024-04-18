package br.com.dio.picpayclone.infrastructure.web.security.usecases;

import br.com.dio.picpayclone.infrastructure.web.requests.LoginRequest;
import br.com.dio.picpayclone.infrastructure.web.responses.TokenResponse;
import br.com.dio.picpayclone.infrastructure.web.security.services.ITokenService;
import br.com.dio.picpayclone.infrastructure.web.mappers.AuthenticationTokenMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthenticateUseCase implements IAuthenticateUseCase {

    private final AuthenticationManager authenticationManager;
    private final ITokenService tokenService;

    public AuthenticateUseCase(AuthenticationManager authenticationManager, ITokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @Override
    public TokenResponse execute(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken loginData = AuthenticationTokenMapper.toAuthenticationToken(loginRequest);
        var authentication = authenticationManager.authenticate(loginData);
        String token = tokenService.generateToken(authentication);
        return new TokenResponse(token, "Bearer");
    }

}
