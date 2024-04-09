package br.com.dio.picpayclone.infrastructure.api.resources;

import br.com.dio.picpayclone.application.dtos.TransactionDTO;
import br.com.dio.picpayclone.application.ports.inbound.IProcessTransactionUseCase;
import br.com.dio.picpayclone.infrastructure.api.mappers.TransactionRequestMapper;
import br.com.dio.picpayclone.infrastructure.api.requests.TransactionRequest;
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

    private final TransactionRequestMapper transactionRequestMapper;
    private final IProcessTransactionUseCase processTransactionUseCase;

    public TransactionResource(
            IProcessTransactionUseCase processTransactionUseCase,
            TransactionRequestMapper transactionRequestMapper) {
        this.processTransactionUseCase = processTransactionUseCase;
        this.transactionRequestMapper = transactionRequestMapper;
    }

    @PostMapping
    public ResponseEntity<TransactionDTO> save(
            @RequestBody @Valid TransactionRequest request,
            UriComponentsBuilder uriComponentsBuilder) {
        TransactionDTO transactionDTO = processTransactionUseCase.execute(transactionRequestMapper.toDto(request));
        String path = "/transactions/{code}";
        return createdItemResponseWithURI(transactionDTO, uriComponentsBuilder, path, transactionDTO.code());
    }

}
