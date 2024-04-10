package br.com.dio.picpayclone.infrastructure.api.resources;

import br.com.dio.picpayclone.application.dtos.UserDTO;
import br.com.dio.picpayclone.application.ports.inbound.IGetUserByLoginUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource extends BaseResource<UserDTO> {

    private final IGetUserByLoginUseCase getUserByLoginUseCase;

    public UserResource(IGetUserByLoginUseCase getUserByLoginUseCase) {
        this.getUserByLoginUseCase = getUserByLoginUseCase;
    }

    @GetMapping("/{login}")
    public ResponseEntity<UserDTO> getByLogin(@PathVariable String login) {
        UserDTO user = getUserByLoginUseCase.execute(login);
        return successResponseWithItem(user);
    }
}
