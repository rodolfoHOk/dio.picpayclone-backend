package br.com.dio.picpayclone.infrastructure.api.resources;

import br.com.dio.picpayclone.application.dtos.TransactionDTO;
import br.com.dio.picpayclone.application.ports.inbound.IListTransactionUseCase;
import br.com.dio.picpayclone.application.ports.inbound.IProcessTransactionUseCase;
import br.com.dio.picpayclone.infrastructure.api.mappers.TransactionRequestMapper;
import br.com.dio.picpayclone.infrastructure.api.requests.TransactionRequest;
import br.com.dio.picpayclone.infrastructure.api.resources.openapi.ITransactionResource;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/transactions")
public class TransactionResource extends BaseResource<TransactionDTO> implements ITransactionResource {

    private final TransactionRequestMapper transactionRequestMapper;
    private final IProcessTransactionUseCase processTransactionUseCase;
    private final IListTransactionUseCase listTransactionUseCase;

    public TransactionResource(
            IProcessTransactionUseCase processTransactionUseCase,
            TransactionRequestMapper transactionRequestMapper,
            IListTransactionUseCase listTransactionUseCase) {
        this.processTransactionUseCase = processTransactionUseCase;
        this.transactionRequestMapper = transactionRequestMapper;
        this.listTransactionUseCase = listTransactionUseCase;
    }

    @Override
    @PostMapping
    public ResponseEntity<TransactionDTO> save(
            @RequestBody @Valid TransactionRequest request,
            UriComponentsBuilder uriComponentsBuilder) {
        TransactionDTO transactionDTO = processTransactionUseCase.execute(transactionRequestMapper.toDto(request));
        String path = "/transactions/{code}";
        return createdItemResponseWithURI(transactionDTO, uriComponentsBuilder, path, transactionDTO.getCode());
    }

    @Override
    @GetMapping
    public ResponseEntity<Page<TransactionDTO>> listByLogin(
            @PageableDefault(page = 0, size = 20) Pageable pageable,
            @RequestParam String login) {
        var pagedTransactions = listTransactionUseCase.execute(pageable, login);
        return pagedItemsListResponse(pagedTransactions);
    }
}
