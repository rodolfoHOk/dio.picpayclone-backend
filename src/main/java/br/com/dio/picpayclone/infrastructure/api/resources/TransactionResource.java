package br.com.dio.picpayclone.infrastructure.api.resources;

import br.com.dio.picpayclone.infrastructure.api.dtos.TransactionDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/transactions")
public class TransactionResource extends BaseResource<TransactionDTO> {

    @PostMapping
    public ResponseEntity<TransactionDTO> save(
            @RequestBody @Valid TransactionDTO transactionDTO,
            UriComponentsBuilder uriComponentsBuilder) {
        TransactionDTO transactionResponseDTO = null; // Todo
        String path = "/transactions/{code}";
        return createdItemResponseWithURI(transactionDTO, uriComponentsBuilder, path, transactionResponseDTO.code());
    }

}
