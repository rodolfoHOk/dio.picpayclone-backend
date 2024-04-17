package br.com.dio.picpayclone.infrastructure.web.resources.openapi;

import br.com.dio.picpayclone.application.dtos.BalanceDTO;
import br.com.dio.picpayclone.application.dtos.UserDTO;
import br.com.dio.picpayclone.infrastructure.web.responses.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Usuários")
public interface IUserResource {

    @Operation(summary = "Consultar usuário por login", responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "401", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    ResponseEntity<UserDTO> getByLogin(
            String login);

    @Operation(summary = "Consultar contatos de um usuário por login", responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "401", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    ResponseEntity<List<UserDTO>> listContactsByLogin(
            String login);

    @Operation(summary = "Consultar saldo de um usuário por login", responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "401", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    ResponseEntity<BalanceDTO> getBalanceByLogin(
            String login);
}
