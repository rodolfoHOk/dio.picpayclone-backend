package br.com.dio.picpayclone.infrastructure.web.security.adapters;

import br.com.dio.picpayclone.application.dtos.LoginDTO;
import br.com.dio.picpayclone.application.dtos.TokenDTO;
import br.com.dio.picpayclone.application.ports.outbound.IAuthenticationGateway;
import br.com.dio.picpayclone.infrastructure.web.mappers.LoginRequestMapper;
import br.com.dio.picpayclone.infrastructure.web.mappers.AuthenticationTokenMapper;
import br.com.dio.picpayclone.infrastructure.web.security.services.ITokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthenticationGateway implements IAuthenticationGateway {

    private final LoginRequestMapper loginRequestMapper;
    private final AuthenticationManager authenticationManager;
    private final ITokenService tokenService;

    public AuthenticationGateway(
            AuthenticationManager authenticationManager,
            ITokenService tokenService,
            LoginRequestMapper loginRequestMapper) {

        this.loginRequestMapper = loginRequestMapper;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @Override
    public TokenDTO authenticate(LoginDTO loginDTO) {
        var loginRequest = loginRequestMapper.toRequest(loginDTO);
        UsernamePasswordAuthenticationToken loginData = AuthenticationTokenMapper.toAuthenticationToken(loginRequest);
        var authentication = authenticationManager.authenticate(loginData);
        String token = tokenService.generateToken(authentication);
        return new TokenDTO(token, "Bearer");
    }

}
