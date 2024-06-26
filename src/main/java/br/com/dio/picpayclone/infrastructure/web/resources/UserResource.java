package br.com.dio.picpayclone.infrastructure.web.resources;

import br.com.dio.picpayclone.application.dtos.BalanceDTO;
import br.com.dio.picpayclone.application.dtos.UserDTO;
import br.com.dio.picpayclone.application.ports.inbound.IGetUserBalanceByLoginUseCase;
import br.com.dio.picpayclone.application.ports.inbound.IGetUserByLoginUseCase;
import br.com.dio.picpayclone.application.ports.inbound.IListUserContactsByLoginUseCase;
import br.com.dio.picpayclone.infrastructure.web.resources.openapi.IUserResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource extends BaseResource<UserDTO> implements IUserResource {

    private final IGetUserByLoginUseCase getUserByLoginUseCase;
    private final IListUserContactsByLoginUseCase listUsersByLoginUseCase;
    private final IGetUserBalanceByLoginUseCase getUserBalanceByLoginUseCase;

    public UserResource(IGetUserByLoginUseCase getUserByLoginUseCase,
                        IListUserContactsByLoginUseCase listUsersByLoginUseCase,
                        IGetUserBalanceByLoginUseCase getUserBalanceByLoginUseCase) {
        this.getUserByLoginUseCase = getUserByLoginUseCase;
        this.listUsersByLoginUseCase = listUsersByLoginUseCase;
        this.getUserBalanceByLoginUseCase = getUserBalanceByLoginUseCase;
    }

    @Override
    @GetMapping("/{login}")
    public ResponseEntity<UserDTO> getByLogin(@PathVariable String login) {
        UserDTO user = getUserByLoginUseCase.execute(login);
        return successResponseWithItem(user);
    }

    @Override
    @GetMapping("/contacts")
    public ResponseEntity<List<UserDTO>> listContactsByLogin(@RequestParam String login) {
        List<UserDTO> users = listUsersByLoginUseCase.execute(login);
        return itemsListResponse(users);
    }

    @Override
    @GetMapping("/{login}/balance")
    public ResponseEntity<BalanceDTO> getBalanceByLogin(@PathVariable String login) {
        BalanceDTO balance = getUserBalanceByLoginUseCase.execute(login);
        return ResponseEntity.ok(balance);
    }
}
