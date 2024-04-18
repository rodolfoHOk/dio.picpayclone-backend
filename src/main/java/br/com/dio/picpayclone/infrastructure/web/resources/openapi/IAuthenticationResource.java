package br.com.dio.picpayclone.infrastructure.web.resources.openapi;

import br.com.dio.picpayclone.infrastructure.web.responses.TokenResponse;
import br.com.dio.picpayclone.infrastructure.web.requests.LoginRequest;
import br.com.dio.picpayclone.infrastructure.web.responses.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Autenticação")
public interface IAuthenticationResource {

    @Operation(summary = "Autêntica usuário", responses = {
            @ApiResponse(responseCode = "201"),
            @ApiResponse(responseCode = "400", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ErrorResponse.class)))),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    @SecurityRequirements()
    ResponseEntity<TokenResponse> authenticate(LoginRequest loginRequest);
}
