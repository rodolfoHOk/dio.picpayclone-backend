package br.com.dio.picpayclone.application.usecases;

import br.com.dio.picpayclone.application.dtos.LoginDTO;
import br.com.dio.picpayclone.application.dtos.TokenDTO;
import br.com.dio.picpayclone.application.ports.inbound.IAuthenticateUseCase;
import br.com.dio.picpayclone.application.ports.inbound.ITokenService;
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
    public TokenDTO execute(LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken loginData = loginDTO.convert();
        var authentication = authenticationManager.authenticate(loginData);
        String token = tokenService.generateToken(authentication);
        return new TokenDTO(token, "Bearer");
    }

}
