package br.com.dio.picpayclone.infrastructure.api.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class AuthenticationResource extends BaseResource<TokenDTO> {

    private final AuthenticationManager authenticationManager;

    public AuthenticationResource(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping
    public ResponseEntity<TokenDTO> authenticate(@RequestBody LoginDTO loginDTO) {
        try {
            UsernamePasswordAuthenticationToken loginData = loginDTO.convert();

            var authentication = authenticationManager.authenticate(loginData);
            var token = tokenService.genarateToken(authentication);

            return successResponseWithItem(new TokenDTO(token, "Bearer"));
        } catch (AuthenticationException exception) {
            return badRequestResponse();
        }
    }
}
