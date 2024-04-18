package br.com.dio.picpayclone.infrastructure.web.resources;

import br.com.dio.picpayclone.infrastructure.web.responses.TokenResponse;
import br.com.dio.picpayclone.infrastructure.web.security.usecases.IAuthenticateUseCase;
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
public class AuthenticationResource extends BaseResource<TokenResponse> implements IAuthenticationResource {

    private final IAuthenticateUseCase authenticateUseCase;

    public AuthenticationResource(
            IAuthenticateUseCase authenticateUseCase
    ) {
        this.authenticateUseCase = authenticateUseCase;
    }

    @Override
    @PostMapping
    public ResponseEntity<TokenResponse> authenticate(@Valid @RequestBody LoginRequest loginRequest) {
        try {
            var tokenResponse = authenticateUseCase.execute(loginRequest);
            return successResponseWithItem(tokenResponse);
        } catch (AuthenticationException exception) {
            return badRequestResponse();
        }
    }

}
