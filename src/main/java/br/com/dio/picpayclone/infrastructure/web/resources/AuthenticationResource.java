package br.com.dio.picpayclone.infrastructure.web.resources;

import br.com.dio.picpayclone.application.dtos.TokenDTO;
import br.com.dio.picpayclone.application.ports.inbound.IAuthenticateUseCase;
import br.com.dio.picpayclone.infrastructure.web.mappers.LoginRequestMapper;
import br.com.dio.picpayclone.infrastructure.web.requests.LoginRequest;
import br.com.dio.picpayclone.infrastructure.web.resources.openapi.IAuthenticationResource;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class AuthenticationResource extends BaseResource<TokenDTO> implements IAuthenticationResource {

    private final LoginRequestMapper loginRequestMapper;
    private final IAuthenticateUseCase authenticateUseCase;

    public AuthenticationResource(
            LoginRequestMapper loginRequestMapper,
            IAuthenticateUseCase authenticateUseCase
    ) {
        this.loginRequestMapper = loginRequestMapper;
        this.authenticateUseCase = authenticateUseCase;
    }

    @Override
    @PostMapping
    public ResponseEntity<TokenDTO> authenticate(@Valid @RequestBody LoginRequest loginRequest) {
        try {
            var loginDTO = loginRequestMapper.toDto(loginRequest);
            var tokenDTO = authenticateUseCase.execute(loginDTO);
            return successResponseWithItem(tokenDTO);
        } catch (AuthenticationException exception) {
            return badRequestResponse();
        }
    }

}
